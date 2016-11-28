package pl.lodz.p.iis.ppkwu.reddit.model;

import pl.lodz.p.iis.ppkwu.reddit.api.ResultStatus;

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
}
