package pl.lodz.p.iis.ppkwu.reddit.impl.model;

import java.util.Objects;

public class Category implements pl.lodz.p.iis.ppkwu.reddit.api.Category {

    private String name;

    @Override
    public String name() {
        return name;
    }

    public Category(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(name, category.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
