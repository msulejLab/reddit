package pl.lodz.p.iis.ppkwu.reddit.impl.model;

import pl.lodz.p.iis.ppkwu.reddit.api.News;
import pl.lodz.p.iis.ppkwu.reddit.api.User;

import java.net.URL;
import java.util.Objects;
import java.util.Optional;

public class NewsImpl implements News {
    private String title;
    private User author;
    private URL thumbnailUrl;

    public NewsImpl(String title, User author, URL thumbnailUrl) {
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

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewsImpl news = (NewsImpl) o;
        return Objects.equals(title, news.title) &&
            Objects.equals(author, news.author) &&
            Objects.equals(thumbnailUrl, news.thumbnailUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, thumbnailUrl);
    }

    @Override
    public String toString() {
        return "NewsImpl{" +
            "title='" + title + '\'' +
            ", author=" + author +
            ", thumbnailUrl=" + thumbnailUrl +
            '}';
    }
}
