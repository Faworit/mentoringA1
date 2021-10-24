package com.epam.ryabtsev;

import com.epam.ryabtsev.thread.CollectionFiller;
import com.epam.ryabtsev.thread.SquareRoot;
import com.epam.ryabtsev.thread.SumNumbers;

import java.util.ArrayList;
import java.util.List;

public class Start {

    public static void main(String[] args) {
        CollectionFiller collectionFiller = new CollectionFiller();
        SumNumbers sumNumbers = new SumNumbers();
        SquareRoot squareRoot = new SquareRoot();

        collectionFiller.start();
        sumNumbers.start();
        squareRoot.start();

    }
}
