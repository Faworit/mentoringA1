package com.epam.ryabtsev;

import java.util.Random;
import java.util.stream.Collectors;

public class Producer extends Thread{
    QueueAction queueAction = new QueueAction();

    public void run() {
        String symbols = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 1; i > 0; i++) {
            long size = new Random().nextInt(250);
            String random = new Random().ints(size, 0, symbols.length())
                    .mapToObj(symbols::charAt)
                    .map(Object::toString)
                    .collect(Collectors.joining());
            synchronized (QueueAction.class) {
                queueAction.addMessage(random);
            }
            try {
                Thread.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
