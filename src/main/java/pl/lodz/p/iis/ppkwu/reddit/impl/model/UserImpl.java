package pl.lodz.p.iis.ppkwu.reddit.impl.model;


import pl.lodz.p.iis.ppkwu.reddit.api.User;

import java.util.Objects;

public class UserImpl implements User {

    private String login;

    public UserImpl(String login) {
        this.login = login;
    }

    public String login() {
        return login;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserImpl user = (UserImpl) o;
        return Objects.equals(login, user.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login);
    }

    @Override
    public String toString() {
        return "UserImpl{" +
            "login='" + login + '\'' +
            '}';
    }
}
