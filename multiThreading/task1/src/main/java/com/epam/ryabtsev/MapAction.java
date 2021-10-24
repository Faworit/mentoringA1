package com.epam.ryabtsev;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MapAction {
    static ConcurrentHashMap<Integer, Integer> nums = new  ConcurrentHashMap<>();

    public static void fillMap(int key, int value) {
        nums.put(key, value);
    }

    public static void mapSumNumber() {
        long sum = 0;
        for (int value : nums.values()) {
            sum = sum + value;
        }
        System.out.println("sum: " + sum);
    }
}
