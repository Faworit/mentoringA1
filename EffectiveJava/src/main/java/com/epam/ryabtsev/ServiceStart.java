package com.epam.ryabtsev;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ServiceStart {

    public static void main(String[] args) throws InterruptedException {
        EvictionPolicy.LFU();
        EvictionPolicy.LRU();
        /*long time = System.currentTimeMillis();
        System.out.println(time);
        Thread.sleep(5000);
        long time2  = System.currentTimeMillis();
        long result = time2 - time;
        long convert = TimeUnit.SECONDS.convert(result, TimeUnit.MILLISECONDS);
        Date date = new Date(time2);
        System.out.println(convert);*/
    }

}
