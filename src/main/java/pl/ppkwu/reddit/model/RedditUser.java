package pl.ppkwu.reddit.model;


import pl.ppkwu.reddit.api.User;

import java.util.Objects;

public class RedditUser implements User {

    private String login;

    public RedditUser(String login) {
        this.login = login;
    }

    public String login() {
        return login;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RedditUser that = (RedditUser) o;
        return Objects.equals(login, that.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login);
    }

    @Override
    public String toString() {
        return "RedditUser{" +
                "login='" + login + '\'' +
                '}';
    }
}
