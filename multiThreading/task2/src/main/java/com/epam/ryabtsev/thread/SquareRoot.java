package com.epam.ryabtsev.thread;

import com.epam.ryabtsev.CollectionAction;

public class SquareRoot extends Thread {

    public void run() {
        while (true) {
            synchronized (CollectionAction.class) {
                CollectionAction.getInstance().printSquareRoot();
            }

            try {
                Thread.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
