package pl.lodz.p.iis.ppkwu.reddit.impl.model;

import pl.lodz.p.iis.ppkwu.reddit.api.Category;

import java.util.Objects;

public class CategoryImpl implements Category {

    private String name;

    @Override
    public String name() {
        return name;
    }

    public CategoryImpl(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryImpl categoryImpl = (CategoryImpl) o;
        return Objects.equals(name, categoryImpl.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "CategoryImpl{" +
            "name='" + name + '\'' +
            '}';
    }
}
