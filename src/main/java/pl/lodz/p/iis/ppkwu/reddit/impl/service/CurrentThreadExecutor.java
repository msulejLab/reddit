package pl.lodz.p.iis.ppkwu.reddit.impl.service;

import java.util.concurrent.Executor;

public class CurrentThreadExecutor implements Executor {

    public CurrentThreadExecutor() {}

    @Override
    public void execute(Runnable command) {
        command.run();
    }
}
