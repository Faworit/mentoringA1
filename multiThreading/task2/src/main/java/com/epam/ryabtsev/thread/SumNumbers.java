package com.epam.ryabtsev.thread;

import com.epam.ryabtsev.CollectionAction;

public class SumNumbers extends Thread {

    public void run() {
        while(true) {
            synchronized (CollectionAction.class) {
                CollectionAction.getInstance().printSumNumbers();
            }

            try {
                Thread.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
