package pl.ppkwu.reddit.model;

import java.util.Objects;

public class Subreddit implements pl.ppkwu.reddit.api.Subreddit{

    private String title;
    private String description;

    public Subreddit(String title, String description) {
        this.title = title;
        this.description = description;
    }

    @Override
    public String title() {
        return null;
    }

    @Override
    public String description() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subreddit subreddit = (Subreddit) o;
        return Objects.equals(title, subreddit.title) &&
                Objects.equals(description, subreddit.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description);
    }

    @Override
    public String toString() {
        return "Subreddit{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
