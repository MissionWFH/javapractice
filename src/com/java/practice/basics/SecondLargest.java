package com.java.practice.basics;

import java.util.Arrays;
import java.util.Comparator;

public class SecondLargest {

    public static void main(String[] args) {

        int[] arr = {14, 46, 47, 86, 82};
        int largest = arr[0];
        int secondLargest = arr[0];
        int smallest = arr[0];

        System.out.println("The given array is:");
        for (int j : arr) {
            System.out.print(j + "\t");
        }

        Integer secondLargestNum = Arrays.stream(arr)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst().orElse(null);
        System.out.println("\n~~ Second largest number is: " + secondLargestNum);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] > secondLargest) {
                secondLargest = arr[i];
            }
        }
        System.out.println("\n\nLargest number is: " + largest);
        System.out.println("\nSecond largest number is: " + secondLargest);

        for (int i : arr) {
            if (i < smallest) {
                smallest = i;
            } else if (i > largest) {
                largest = i;
            }
        }
        System.out.println("\nLargest number is: " + largest);
        System.out.println("\nSmallest number is: " + smallest);
    }
}