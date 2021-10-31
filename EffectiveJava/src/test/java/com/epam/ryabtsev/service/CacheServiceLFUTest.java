package com.epam.ryabtsev.service;

import com.epam.ryabtsev.entity.CacheObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CacheServiceLFUTest {

    @Test
    void getValue() {
        //given
        Object object = null;
        CacheObject cacheObject = new CacheObject();

        //when
        CacheServiceLFU.init().put(1, cacheObject);
        object = CacheServiceLFU.init().get(1);

        //then
        Assertions.assertNotEquals(object, null);
    }

    @Test
    void capacity() {
        //given
        int capacity = 100000;
        CacheObject cacheObject = new CacheObject();
        CacheServiceLFU cacheServiceLFU = CacheServiceLFU.init();

        //when
        cacheServiceLFU.put(1, cacheObject);

        //then

        Assertions.assertEquals(capacity, CacheServiceLFU.init().getCacheValue().size());

    }
}