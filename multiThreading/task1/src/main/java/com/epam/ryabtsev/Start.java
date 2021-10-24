package com.epam.ryabtsev;

import com.epam.ryabtsev.threads.MapFiller;
import com.epam.ryabtsev.threads.MapValueSum;

import java.util.HashMap;
import java.util.Map;

public class Start {

    public static void main(String[] args) {
        Thread mapFiller = new Thread(new MapFiller());
        MapValueSum sum = new MapValueSum();

        mapFiller.start();
        sum.start();

    }
}
