package pl.lodz.p.iis.ppkwu.reddit.impl.model;

import pl.lodz.p.iis.ppkwu.reddit.api.ResultStatus;

import java.util.Objects;
import java.util.Optional;

public class ResultImpl<R> implements pl.lodz.p.iis.ppkwu.reddit.api.Result<R> {

    private ResultStatus resultStatus;
    private R content;

    public ResultImpl(ResultStatus resultStatus, R content) {
        this.resultStatus = resultStatus;
        this.content = content;
    }

    @Override
    public boolean succeeded() {
        return resultStatus.equals(ResultStatus.SUCCEEDED);
    }

    @Override
    public ResultStatus status() {
        return resultStatus;
    }

    @Override
    public Optional<R> content() {
        return Optional.ofNullable(content);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultImpl<?> result = (ResultImpl<?>) o;
        return resultStatus == result.resultStatus &&
            Objects.equals(content, result.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resultStatus, content);
    }

    @Override
    public String toString() {
        return "ResultImpl{" +
            "resultStatus=" + resultStatus +
            ", content=" + content +
            '}';
    }
}
