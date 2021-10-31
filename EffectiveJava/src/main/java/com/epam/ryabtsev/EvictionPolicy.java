package com.epam.ryabtsev;

import com.epam.ryabtsev.service.CacheServiceLFU;
import org.apache.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class EvictionPolicy {
    private static Logger logger = Logger.getLogger(EvictionPolicy.class);

    public static void LFU() {
        long start = System.nanoTime();
        CacheServiceLFU cacheServiceLFU = CacheServiceLFU.init();
        long end = System.nanoTime();
        long fillCacheTime = end - start;
        System.out.println(cacheServiceLFU.getCacheValue().size());

        if (fillCacheTime > 0) {
            long averageTimeForValue = 100000/(TimeUnit.SECONDS.convert(fillCacheTime, TimeUnit.MILLISECONDS));
            logger.info("Average time spent for putting new values into the cache: " + averageTimeForValue + " nano seconds");
        }

    }

    public static void LRU() {

    }
}
