package com.java.practice.basics;

import java.util.Arrays;
import java.util.Comparator;

public class SecondLargest {

    public static void main(String[] args) {

        int[] arr = SearchElement.getRandomNums();
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;

        System.out.println("The given array is: " + Arrays.toString(arr));

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] > secondLargest && arr[i] != largest) {
                secondLargest = arr[i];
            }
            if (arr[i] < smallest) {
                smallest = arr[i];
            }
        }
        System.out.println("\nLargest number is: " + largest);
        System.out.println("Second largest number is: " + secondLargest);
        System.out.println("Smallest number is: " + smallest);

        Integer secondLargestNum = Arrays.stream(arr)
                .boxed()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst().orElse(null);
        System.out.println("\nSecond largest number using stream is: " + secondLargestNum);
    }
}