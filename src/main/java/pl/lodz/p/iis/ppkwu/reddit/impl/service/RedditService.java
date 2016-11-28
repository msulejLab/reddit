package pl.lodz.p.iis.ppkwu.reddit.impl.service;

import pl.lodz.p.iis.ppkwu.reddit.api.*;

import java.util.List;
import java.util.concurrent.Executor;

// TODO implement :-)
public class RedditService implements Reddit {

    private Executor executor;


    // Tworzony przy pomocy buildera
    RedditService(Executor executor) {
        this.executor = executor;
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
