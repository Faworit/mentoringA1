package com.epam.ryabtsev.threads;

import com.epam.ryabtsev.MapAction;

public class MapValueSum extends Thread {

    public void run() {
        for (int i = 1; i > 0; i++) {
            MapAction.mapSumNumber();
            try {
                Thread.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
