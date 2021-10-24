package com.epam.ryabtsev;

import java.util.concurrent.Callable;

public class Consumer implements Callable<String> {
    QueueAction queueAction = new QueueAction();

    @Override
    public String call() throws Exception {
        Thread.sleep(4);
        return queueAction.readMessage();
    }
}
