package com.epam.ryabtsev;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CollectionAction {
    static List<Integer> nums = new ArrayList<>();;
    private static boolean collectionExist = false;

    public void addNumber() {
        Random random = new Random();
        nums.add(random.nextInt(50));
    }

    public void printSumNumbers() {
        long sum = 0;
        for (int value : nums) {
            sum += value;
        }
        System.out.println("Prinf sum: " + sum);
    }

    public void printSquareRoot() {
        long sum = 0;
        for (int value : nums) {
            sum += (long) value * value;
        }

        if (sum > 0) {
            System.out.println("Print sqrt: " + Math.sqrt(sum));
        }
    }
}
