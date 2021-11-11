package com.epam.ryabtsev;

import com.epam.ryabtsev.entity.Entry;
import com.epam.ryabtsev.service.CacheServiceLRU;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestLRU {
    private static ExecutorService executorService = Executors.newCachedThreadPool();
    private static Random random = new Random();
    private CacheServiceLRU cacheServiceLRU = CacheServiceLRU.getInstance();


    public synchronized void checkLRU() {
        for (int i = 0; i < 100; i++) {
            cacheServiceLRU.get();
        }

        cacheServiceLRU.put(new Entry("EntryAdd1"));
        cacheServiceLRU.put(new Entry("EntryAdd2"));
        cacheServiceLRU.put(new Entry("EntryAdd3"));
        cacheServiceLRU.put(new Entry("EntryAdd4"));

    }
}
