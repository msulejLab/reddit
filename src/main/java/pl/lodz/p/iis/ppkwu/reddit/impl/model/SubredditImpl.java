package pl.lodz.p.iis.ppkwu.reddit.impl.model;

import pl.lodz.p.iis.ppkwu.reddit.api.Subreddit;

import java.util.Objects;

public class SubredditImpl implements Subreddit {

    private String title;

    public SubredditImpl(String title) {
        this.title = title;
    }

    @Override
    public String title() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubredditImpl subreddit = (SubredditImpl) o;
        return Objects.equals(title, subreddit.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public String toString() {
        return "SubredditImpl{" +
            "title='" + title + '\'' +
            '}';
    }
}