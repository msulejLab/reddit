package pl.lodz.p.iis.ppkwu.reddit.impl.service;

import net.dean.jraw.RedditClient;
import net.dean.jraw.http.UserAgent;
import net.dean.jraw.http.oauth.Credentials;
import net.dean.jraw.http.oauth.OAuthData;
import net.dean.jraw.http.oauth.OAuthException;
import net.dean.jraw.models.Contribution;
import net.dean.jraw.models.Listing;
import net.dean.jraw.models.Submission;
import net.dean.jraw.paginators.Sorting;
import net.dean.jraw.paginators.SubredditPaginator;
import net.dean.jraw.paginators.UserContributionPaginator;
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
        callback.finished(new ResultImpl<>(ResultStatus.SUCCEEDED, categories));
    }

    @Override
    public void loadSubredditNews(Subreddit subreddit, Category category, Callback<Page<News>> callback) throws NullPointerException {
        SubredditPaginator page = new SubredditPaginator(redditClient);
        page.setSubreddit(subreddit.title());
        page.setLimit(10);
        page.setSorting(resolveSortingType(category));
        Listing<Submission> submissions = page.next();

        List<News> subredditNews = new LinkedList<>();
        for (Submission submission : submissions) {
            URL url;
            try {
                url = new URL(submission.getThumbnail());
            } catch (MalformedURLException e) {
                url = null;
            }
            NewsImpl news1 = new NewsImpl(submission.getTitle(), new UserImpl(submission.getAuthor()), url);
            subredditNews.add(news1);
        }

        callback.finished(new ResultImpl<>(ResultStatus.SUCCEEDED, new PageImpl<>(subredditNews)));
    }

    @Override
    public void loadUserNews(User user, Callback<Page<News>> callback) throws NullPointerException {
        UserContributionPaginator page = new UserContributionPaginator(redditClient, "submitted", user.login());
        Listing<Contribution> contributions = page.next();

        List<News> userNews = new LinkedList<>();
        for(Contribution contribution: contributions){
            URL url;
            try {
                url = new URL(contribution.data("url"));
            } catch (MalformedURLException e) {
                url = null;
            }
            News news = new NewsImpl(contribution.data("title"), new UserImpl(contribution.data("author")), url);
            userNews.add(news);
        }

        callback.finished(new ResultImpl<>(ResultStatus.SUCCEEDED, new PageImpl<>(userNews)));
    }

    @Override
    public void loadNewsByKeywords(List<String> keywords, Callback<Page<News>> callback) throws NullPointerException {

    }

    @Override
    public User userWithLogin(String login) {
        if(redditClient.getUser(login) != null){
            return new UserImpl(login);
        }
        return null;
    }

    @Override
    public Subreddit subredditWithName(String name) {
        String title = redditClient.getSubreddit(name).getTitle();
        return new SubredditImpl(title);
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
