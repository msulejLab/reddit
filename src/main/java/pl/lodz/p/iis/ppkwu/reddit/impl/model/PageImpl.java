package pl.lodz.p.iis.ppkwu.reddit.impl.model;

import pl.lodz.p.iis.ppkwu.reddit.api.Page;

import java.util.List;
import java.util.Objects;

public class PageImpl<C> implements Page<C> {

    private final List<C> content;

    public PageImpl(List<C> content) {
        this.content = content;
    }

    @Override
    public List<C> content() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PageImpl<?> page = (PageImpl<?>) o;
        return Objects.equals(content, page.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }

    @Override
    public String toString() {
        return "Page{" +
            "content=" + content +
            '}';
    }
}
