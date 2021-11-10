package com.epam.ryabtsev;

import com.epam.ryabtsev.entity.CacheObject;
import com.epam.ryabtsev.service.CacheServiceLFU;
import org.apache.log4j.Logger;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class PreparationLFU {
    private static Logger logger = Logger.getLogger(PreparationLFU.class);

    public synchronized static void LFU() {
        long start = System.nanoTime();
        CacheServiceLFU cacheServiceLFU = CacheServiceLFU.getInstance();
        long end = System.nanoTime();
        long averageTimeForValue = 100000/(TimeUnit.SECONDS.convert(end - start, TimeUnit.MILLISECONDS));
        logger.info("Average time spent for putting new values into the cache: " + averageTimeForValue + " nano seconds");

        for (int i = 0; i < 10000; i++) {
            Random random = new Random();
            cacheServiceLFU.get(random.nextInt(100000));
        }

        cacheServiceLFU.put(200000, new CacheObject(String.valueOf(200000)));
        cacheServiceLFU.put(333333, new CacheObject(String.valueOf(333333)));
        cacheServiceLFU.put(200555, new CacheObject(String.valueOf(200555)));
        cacheServiceLFU.put(219419, new CacheObject(String.valueOf(219419)));
        logger.info("Cache size after after add new Object" + cacheServiceLFU.getCacheValue().size());

        logger.info("take new object: " + cacheServiceLFU.get(200000).getName());
        logger.info("take new object: " + cacheServiceLFU.get(333333).getName());
        logger.info("take new object: " + cacheServiceLFU.get(200555).getName());
        logger.info("take new object: " + cacheServiceLFU.get(219419).getName());
    }

    public static void LRU() {

    }
}
