package com.epam.ryabtsev.service;

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

}