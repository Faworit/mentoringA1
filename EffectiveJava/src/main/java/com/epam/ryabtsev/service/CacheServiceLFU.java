package com.epam.ryabtsev.service;

import com.epam.ryabtsev.entity.CacheObject;
import com.epam.ryabtsev.entity.EvictionPolicy;
import org.apache.log4j.Logger;

import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;


public class CacheServiceLFU {
    private static Logger logger = Logger.getLogger(CacheServiceLFU.class);
    private final int CAPACITY = 100000;
    private ConcurrentHashMap<Integer, CacheObject> cacheValue = new ConcurrentHashMap<>(CAPACITY);
    private ConcurrentHashMap<Integer, EvictionPolicy> cache = new ConcurrentHashMap<>(CAPACITY);
    private static CacheServiceLFU cacheServiceLFU = null;

    private CacheServiceLFU() {
        while (cache.size() < 100000) {
            Random random = new Random();
            int value = random.nextInt(100000);
            put(value, new CacheObject(String.valueOf(value)));
        }
    }

    public static synchronized CacheServiceLFU init() {
        if (cacheServiceLFU == null) {
            cacheServiceLFU = new CacheServiceLFU();
        }
        return cacheServiceLFU;
    }

    public synchronized void put(int key, CacheObject cacheObject) {
        CacheObject v = cacheValue.get(key);
        if (v == null) {
            if (cache.size() == CAPACITY) {
                Integer k = getKickedKey();
                cacheValue.remove(k);
                cache.remove(k);
                logger.info("Was removed: " + k);
            }
            cache.put(key, new EvictionPolicy(key, 1, System.nanoTime()));
        } else {
            EvictionPolicy objectRate = cache.get(key);
            objectRate.setHitCount(objectRate.getHitCount() + 1);
            objectRate.setLastTime(System.nanoTime());
        }
        cacheValue.put(key, cacheObject);
    }

    private Integer getKickedKey() {
        EvictionPolicy min = Collections.min(cache.values());
        return min.getKey();
    }


    public synchronized CacheObject get(int key) {
        CacheObject cacheObject = cacheValue.get(key);
        EvictionPolicy evictionPolicy = cache.get(key);
        if (evictionPolicy.getHitCount() != null) {
            evictionPolicy.setHitCount(evictionPolicy.getHitCount() + 1);
        } else {
            evictionPolicy.setHitCount(1);
        }

        evictionPolicy.setLastTime(System.nanoTime());

        return cacheObject;  
    }

    public ConcurrentHashMap<Integer, CacheObject> getCacheValue() {
        return cacheValue;
    }
}
