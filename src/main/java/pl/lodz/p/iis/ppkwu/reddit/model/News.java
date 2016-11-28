package pl.lodz.p.iis.ppkwu.reddit.model;

import java.net.URL;
import java.util.Optional;

public class News implements pl.lodz.p.iis.ppkwu.reddit.api.News {
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
