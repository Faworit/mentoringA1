package com.epam.ryabtsev;

import com.epam.ryabtsev.service.CacheServiceLFU;
import org.apache.log4j.BasicConfigurator;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServiceStart {

    public static void main(String[] args) throws InterruptedException {
        BasicConfigurator.configure();
        CacheServiceLFU.getInstance();

        ExecutorService ex = Executors.newCachedThreadPool();
        ex.execute(new CacheConcurrency());
        ex.execute(new CacheConcurrency());

        TestLFU.createParameter();
       // EvictionPolicy.LRU();
    }

}
