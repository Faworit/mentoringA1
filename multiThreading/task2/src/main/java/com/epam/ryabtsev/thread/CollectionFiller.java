package com.epam.ryabtsev.thread;

import com.epam.ryabtsev.CollectionAction;

public class CollectionFiller extends Thread {

    public void run() {
        while(true) {
            synchronized (CollectionAction.class) {
                CollectionAction.getInstance().addNumber();
            }
            try {
                Thread.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
