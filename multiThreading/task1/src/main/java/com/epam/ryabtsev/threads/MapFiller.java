package com.epam.ryabtsev.threads;

import com.epam.ryabtsev.MapAction;

public class MapFiller implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i < 1000; i++) {
            MapAction.fillMap(i, i);
            try {
                Thread.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
