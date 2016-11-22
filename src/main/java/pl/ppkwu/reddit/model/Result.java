package pl.ppkwu.reddit.model;

import pl.ppkwu.reddit.api.ResultStatus;

import java.util.Optional;

public class Result<R> implements pl.ppkwu.reddit.api.Result<R> {

    private boolean succeeded;
    private ResultStatus resultStatus;
    private R content;

    public Result(boolean succeeded, ResultStatus resultStatus, R content) {
        this.succeeded = succeeded;
        this.resultStatus = resultStatus;
        this.content = content;
    }

    @Override
    public boolean succeeded() {
        return succeeded;
    }

    @Override
    public ResultStatus status() {
        return resultStatus;
    }

    @Override
    public Optional<R> content() {
        return Optional.ofNullable(content);
    }
}
