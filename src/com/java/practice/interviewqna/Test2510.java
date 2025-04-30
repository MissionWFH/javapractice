package com.java.practice.interviewqna;

import java.util.stream.IntStream;

public class Test2510 {

    public static void main(String[] args) {
        IntStream intStream = IntStream.rangeClosed(1, 100);

        int[] numbers = {1, 2, 3, 4, 5, 6, 8, 9, 10};
        int expectedSum = 10 * (10 + 1) / 2; // N * (N + 1) / 2
        int actualSum = 0;
        for (int number : numbers) {
            actualSum += number;
        }

        // Find the missing number
        int missingNumber = expectedSum - actualSum;

        System.out.println("The missing number is: " + missingNumber);

    }
}