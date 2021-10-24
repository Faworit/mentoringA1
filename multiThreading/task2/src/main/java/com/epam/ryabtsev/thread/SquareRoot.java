package com.epam.ryabtsev.thread;

import com.epam.ryabtsev.CollectionAction;

public class SquareRoot extends Thread {
    CollectionAction collectionAction = new CollectionAction();

    public void run() {
        for (int i = 1; i > 0; i++) {
            synchronized (CollectionAction.class) {
                collectionAction.printSquareRoot();
            }

            try {
                Thread.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
