package pl.lodz.p.iis.ppkwu.reddit.impl.service;

import pl.lodz.p.iis.ppkwu.reddit.api.Reddit;

import java.util.concurrent.Executor;

public class RedditBuilder implements pl.lodz.p.iis.ppkwu.reddit.api.RedditBuilder {

    private Executor callbackExecutor;

    @Override
    public Reddit build() {
        if (callbackExecutor == null) {
            return new RedditService(new CurrentThreadExecutor());
        } else {
            return new RedditService(callbackExecutor);
        }
    }

    @Override
    public pl.lodz.p.iis.ppkwu.reddit.api.RedditBuilder withCallbackExecutor(Executor callbackExecutor) {
        this.callbackExecutor = callbackExecutor;
        return this;
    }
}
