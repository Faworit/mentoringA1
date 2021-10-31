package com.epam.ryabtsev.service;

import com.epam.ryabtsev.entity.CacheObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CacheServiceLFUTest {

    CacheServiceLFU cacheServiceLFU = new CacheServiceLFU();

    @Test
    void getValue() {
        //given
        Object object = null;

        //when
        object = cacheServiceLFU.get();

        //then
        Assertions.assertNotEquals(object, null);
    }

    @Test
    void capacity() {
        //given
        int capacity = 100000;
        CacheObject cacheObject = new CacheObject();

        //when
        cacheServiceLFU.put(cacheObject);

        //then

        Assertions.assertEquals(capacity, cacheServiceLFU.getCache.size());

    }
}