package com.epam.ryabtsev.service;

import com.epam.ryabtsev.Listener;
import com.epam.ryabtsev.entity.Entry;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CacheServiceLRU {
    final static long CACHE_MAX_SIZE = 100000L;
    private static Random random = new Random();
    private static CacheServiceLRU cacheServiceLRU = null;
    private static Cache<Long, Entry> cache = CacheBuilder.newBuilder()
            .maximumSize(CACHE_MAX_SIZE)
            .expireAfterAccess(5, TimeUnit.SECONDS)
            .concurrencyLevel(10)
            .removalListener(new Listener())
            .build();

    public static synchronized CacheServiceLRU getInstance() {
        if (cacheServiceLRU == null) {
            cacheServiceLRU = new CacheServiceLRU();
        }
        return cacheServiceLRU;
    }

    private CacheServiceLRU() {
        for (long i = 0; i < CACHE_MAX_SIZE; i++) {
            cache.put(i, new Entry("Entry " + i));
        }
    }

    public void put(Object object) {
        long key = getRandomLong();
        try {
            Thread.sleep(random.nextInt(10) * 100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        cache.put(key, new Entry("Value" + key));

    }

    private static long getRandomLong() {
        long r = random.nextLong();
        long exceptExisting = r > CACHE_MAX_SIZE ? r : r + CACHE_MAX_SIZE;
        if (exceptExisting < 0)
            return getRandomLong();

        return exceptExisting;
    }

    public Object get() {
        return cache.getIfPresent(new Entry("Entry " + random.nextInt(100)));
    }
}
