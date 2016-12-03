package pl.lodz.p.iis.ppkwu.reddit.impl.service;

import net.dean.jraw.RedditClient;
import net.dean.jraw.http.UserAgent;
import net.dean.jraw.http.oauth.Credentials;
import net.dean.jraw.http.oauth.OAuthData;
import net.dean.jraw.http.oauth.OAuthException;
import pl.lodz.p.iis.ppkwu.reddit.api.*;
import pl.lodz.p.iis.ppkwu.reddit.impl.model.Result;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executor;

// TODO implement :-)
public class RedditService implements Reddit {

    private static final List<Category> categories = new LinkedList<Category>(){{
        add(new pl.lodz.p.iis.ppkwu.reddit.impl.model.Category("gorace"));
        add(new pl.lodz.p.iis.ppkwu.reddit.impl.model.Category("najnowsze"));
        add(new pl.lodz.p.iis.ppkwu.reddit.impl.model.Category("wschodzace"));
        add(new pl.lodz.p.iis.ppkwu.reddit.impl.model.Category("kontrowersyjne"));
        add(new pl.lodz.p.iis.ppkwu.reddit.impl.model.Category("najwiecej punktow"));
        add(new pl.lodz.p.iis.ppkwu.reddit.impl.model.Category("pozlocone"));
        add(new pl.lodz.p.iis.ppkwu.reddit.impl.model.Category("wiki"));
        add(new pl.lodz.p.iis.ppkwu.reddit.impl.model.Category("promowane"));
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
        } catch (OAuthException e) {
            throw new IllegalArgumentException("Initialization exception", e);
        }
    }

    @Override
    public void loadCategoriesList(Callback<List<Category>> callback) throws NullPointerException {
        callback.finished(new Result<>(ResultStatus.SUCCEEDED, categories));
    }

    @Override
    public void loadSubredditNews(Subreddit subreddit, Category category, Callback<Page<News>> callback) throws NullPointerException {

    }

    @Override
    public void loadUserNews(User user, Callback<Page<News>> callback) throws NullPointerException {

    }

    @Override
    public void loadNewsByKeywords(List<String> keywords, Callback<Page<News>> callback) throws NullPointerException {

    }

    @Override
    public User userWithLogin(String login) {
        return null;
    }

    @Override
    public Subreddit subredditWithName(String name) {
        return null;
    }
}
