package com.epam.ryabtsev;

import java.util.Random;
import java.util.stream.Collectors;

public class Producer extends Thread{

    @Override
    public void run() {
        String symbols = "abcdefghijklmnopqrstuvwxyz";
        while(true) {
            long size = new Random().nextInt(250);
            String random = new Random().ints(size, 0, symbols.length())
                    .mapToObj(symbols::charAt)
                    .map(Object::toString)
                    .collect(Collectors.joining());

            try {
                QueueAction.getInstance().addMessage(random);
                Thread.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
