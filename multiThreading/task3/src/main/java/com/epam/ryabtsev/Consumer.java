package com.epam.ryabtsev;

import java.util.concurrent.Callable;

public class Consumer implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(4);
        return QueueAction.getInstance().readMessage();
    }
}
