package pl.lodz.p.iis.ppkwu.reddit.impl.service;

import pl.lodz.p.iis.ppkwu.reddit.api.*;

import java.util.List;

// TODO implement :-)
public class RedditService implements Reddit {

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
