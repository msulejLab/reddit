package pl.ppkwu.reddit.model;

import pl.ppkwu.reddit.api.*;
import pl.ppkwu.reddit.api.User;

import java.net.URL;
import java.util.Optional;

/**
 * Created by 187796 on 11/22/2016.
 */
public class News implements pl.ppkwu.reddit.api.News {
    private String title;
    private User author;
    private URL thumbnailUrl;

    public News(String title, User author, URL thumbnailUrl) {
        this.title = title;
        this.author = author;
        this.thumbnailUrl = thumbnailUrl;
    }

    @Override
    public String title() {
        return title;
    }

    @Override
    public User author() {
        return author;
    }

    @Override
    public Optional<URL> thumbnailUrl() {
        return Optional
                .ofNullable(thumbnailUrl);
    }
}
