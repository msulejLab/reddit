package pl.lodz.p.iis.ppkwu.reddit.impl.model;

import java.util.Objects;

public class Subreddit implements pl.lodz.p.iis.ppkwu.reddit.api.Subreddit {

    private String title;

    public Subreddit(String title) {
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
        Subreddit subreddit = (Subreddit) o;
        return Objects.equals(title, subreddit.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }


}