package com.epam.ryabtsev;

import com.epam.ryabtsev.entity.CacheObject;
import com.epam.ryabtsev.service.CacheServiceLFU;

import java.util.Random;

public class CacheConcurrency extends Thread{

    @Override
    public void run() {
        CacheServiceLFU cacheServiceLFU = CacheServiceLFU.init();
        for (int i = 0; i < 10; i++) {
            System.out.println("In Thread");
            Random random = new Random();
            int value = random.nextInt(100000);
            cacheServiceLFU.put(value, new CacheObject(String.valueOf(value)));
            try {
                sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
