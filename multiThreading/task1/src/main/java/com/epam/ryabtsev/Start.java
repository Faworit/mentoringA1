package com.epam.ryabtsev;

import com.epam.ryabtsev.threads.MapFiller;
import com.epam.ryabtsev.threads.MapValueSum;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.runner.RunnerException;

import java.io.IOException;
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
