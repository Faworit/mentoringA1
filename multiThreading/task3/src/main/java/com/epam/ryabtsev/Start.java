package com.epam.ryabtsev;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Start {

    public static void main(String[] args) {
        Producer producer = new Producer();
        Consumer consumer = new Consumer();

        producer.start();

        for (int i = 1; i > 0; i++) {
            try {
                ExecutorService ex = Executors.newCachedThreadPool();
                Future<String> message = ex.submit(new Consumer());

                System.out.println("Message from queue" + message.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
