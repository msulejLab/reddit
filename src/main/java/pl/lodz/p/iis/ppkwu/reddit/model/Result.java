package pl.lodz.p.iis.ppkwu.reddit.model;

import pl.lodz.p.iis.ppkwu.reddit.api.ResultStatus;

import java.util.Objects;
import java.util.Optional;

public class Result<R> implements pl.lodz.p.iis.ppkwu.reddit.api.Result<R> {

    private ResultStatus resultStatus;
    private R content;

    public Result(ResultStatus resultStatus, R content) {
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
        Result<?> result = (Result<?>) o;
        return resultStatus == result.resultStatus &&
            Objects.equals(content, result.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resultStatus, content);
    }

    @Override
    public String toString() {
        return "Result{" +
            "resultStatus=" + resultStatus +
            ", content=" + content +
            '}';
    }
}
