package pl.lodz.p.iis.ppkwu.reddit.model;


import java.util.Objects;

public class User implements pl.lodz.p.iis.ppkwu.reddit.api.User {

    private String login;

    public User(String login) {
        this.login = login;
    }

    public String login() {
        return login;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(login, user.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login);
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                '}';
    }
}
