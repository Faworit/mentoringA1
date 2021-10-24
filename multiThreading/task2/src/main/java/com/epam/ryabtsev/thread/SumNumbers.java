package com.epam.ryabtsev.thread;

import com.epam.ryabtsev.CollectionAction;

public class SumNumbers extends Thread {
    CollectionAction collectionAction = new CollectionAction();

    public void run() {
        for (int i = 1; i > 0; i++) {
            synchronized (CollectionAction.class) {
                collectionAction.printSumNumbers();
            }

            try {
                Thread.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
