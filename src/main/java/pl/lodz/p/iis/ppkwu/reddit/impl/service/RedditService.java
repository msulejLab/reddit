package pl.lodz.p.iis.ppkwu.reddit.impl.service;

import net.dean.jraw.RedditClient;
import net.dean.jraw.http.UserAgent;
import net.dean.jraw.http.oauth.Credentials;
import net.dean.jraw.http.oauth.OAuthData;
import net.dean.jraw.http.oauth.OAuthException;
import pl.lodz.p.iis.ppkwu.reddit.api.*;

import java.util.List;
import java.util.concurrent.Executor;

import static java.lang.System.out;

// TODO implement :-)
public class RedditService implements Reddit {

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
