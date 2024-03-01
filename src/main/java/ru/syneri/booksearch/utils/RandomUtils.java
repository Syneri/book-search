package ru.syneri.booksearch.utils;

import java.util.Random;

public class RandomUtils {

    public static int[] getRandomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (new Random()).nextInt();
        }
        return arr;
    }
}
