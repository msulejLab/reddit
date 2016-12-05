package pl.lodz.p.iis.ppkwu.reddit.impl.service;

import com.sun.deploy.util.StringUtils;
import net.dean.jraw.RedditClient;
import net.dean.jraw.http.UserAgent;
import net.dean.jraw.http.oauth.Credentials;
import net.dean.jraw.http.oauth.OAuthData;
import net.dean.jraw.http.oauth.OAuthException;
import net.dean.jraw.models.Contribution;
import net.dean.jraw.models.Listing;
import net.dean.jraw.models.Submission;
import net.dean.jraw.paginators.*;
import pl.lodz.p.iis.ppkwu.reddit.api.*;
import pl.lodz.p.iis.ppkwu.reddit.impl.model.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executor;

// TODO implement :-)
public class RedditService implements Reddit {

    private static final List<Category> categories = new LinkedList<Category>() {{
        add(new CategoryImpl("gorace"));
        add(new CategoryImpl("najnowsze"));
        add(new CategoryImpl("wschodzace"));
        add(new CategoryImpl("kontrowersyjne"));
        add(new CategoryImpl("najwiecej punktow"));
        add(new CategoryImpl("pozlocone"));
        add(new CategoryImpl("wiki"));
        add(new CategoryImpl("promowane"));
    }};

    private Executor executor;
    private final RedditClient redditClient;

    RedditService(Executor executor) {
        this.executor = executor;

        UserAgent myUserAgent = UserAgent.of("desktop", "pl.lodz.p.iis.ppkwu.reddit", "v1", "ppkwu-reddit");
        redditClient = new RedditClient(myUserAgent);
        Credentials credentials = Credentials.script("ppkwu-reddit", "ppkwu-reddit", "XWHE1d691V9S4A", "r_5dy9HgYFYjG4aVIrgVenXZhCk");

        OAuthData authData = null;
        try {
            authData = redditClient.getOAuthHelper().easyAuth(credentials);
            redditClient.authenticate(authData);
        } catch (OAuthException e) {
            throw new IllegalArgumentException("Initialization exception", e);
        }
    }

    @Override
    public void loadCategoriesList(Callback<List<Category>> callback) throws NullPointerException {
        executor.execute(() -> {
            callback.finished(new ResultImpl<>(ResultStatus.SUCCEEDED, categories));
        });
    }

    @Override
    public void loadSubredditNews(Subreddit subreddit, Category category, Callback<Page<News>> callback) throws NullPointerException {
        executor.execute(() -> {
            SubredditPaginator page = new SubredditPaginator(redditClient);
            page.setSubreddit(subreddit.title());
            page.setLimit(10);
            page.setSorting(resolveSortingType(category));
            Listing<Submission> submissions = page.next();

            List<News> subredditNews = new LinkedList<>();
            for (Submission submission : submissions) {
                URL url = createURL(submission.getThumbnail());
                NewsImpl news = new NewsImpl(submission.getTitle(), new UserImpl(submission.getAuthor()), url);
                subredditNews.add(news);
            }

            callback.finished(new ResultImpl<>(ResultStatus.SUCCEEDED, new PageImpl<>(subredditNews)));
        });
    }

    @Override
    public void loadUserNews(User user, Callback<Page<News>> callback) throws NullPointerException {
        executor.execute(() -> {
            UserContributionPaginator page = new UserContributionPaginator(redditClient, "submitted", user.login());
            Listing<Contribution> contributions = page.next();

            List<News> userNews = new LinkedList<>();
            for(Contribution contribution: contributions){
                URL url = createURL(contribution.data("url"));
                News news = new NewsImpl(contribution.data("title"), new UserImpl(contribution.data("author")), url);
                userNews.add(news);
            }

            callback.finished(new ResultImpl<>(ResultStatus.SUCCEEDED, new PageImpl<>(userNews)));
        });
    }

    @Override
    public void loadNewsByKeywords(List<String> keywords, Callback<Page<News>> callback) throws NullPointerException {
        executor.execute(() -> {
            String query = StringUtils.join(keywords, "+");
            SubmissionSearchPaginator page = new SubmissionSearchPaginator(redditClient, query);
            Listing<Submission> submissions = page.next();

            List<News> searchedNews = new LinkedList<>();
            for (Submission submission : submissions) {
                URL url = createURL(submission.getUrl());
                News news = new NewsImpl(submission.getTitle(), new UserImpl(submission.getAuthor()), url);
                searchedNews.add(news);
            }
            callback.finished(new ResultImpl<>(ResultStatus.SUCCEEDED, new PageImpl<News>(searchedNews)));
        });
    }

    @Override
    public User userWithLogin(String login) {
        return new UserImpl(login);
    }

    @Override
    public Subreddit subredditWithName(String name) {
        return new SubredditImpl(name);
    }

    private URL createURL(String urlString){
        URL url;
        try {
            url = new URL(urlString);
        } catch (MalformedURLException e) {
            url = null;
        }
        return url;
    }

    private Sorting resolveSortingType(Category category) {
        switch (category.name()) {
            case "gorace":
                return Sorting.HOT;
            case "najnowsze":
                return Sorting.NEW;
            case "wschodzace":
                return Sorting.RISING;
            case "kontrowersyjne":
                return Sorting.CONTROVERSIAL;
            case "najwiecej punktow":
                return Sorting.TOP;
            case "pozlocone":
                return Sorting.GILDED;
        }
        return Sorting.HOT;
    }
}
