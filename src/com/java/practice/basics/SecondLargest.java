package com.java.practice.basics;

import java.util.Arrays;
import java.util.Comparator;

public class SecondLargest {

    public static void main(String[] args) {

        int[] arr = SearchElement.getRandomNums();
        int largest = arr[0];
        int secondLargest = arr[0];
        int smallest = arr[0];

        System.out.println("The given array is: " + Arrays.deepToString(Arrays.stream(arr).boxed().toArray()));

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] > secondLargest) {
                secondLargest = arr[i];
            }
        }
        System.out.println("\nLargest number is: " + largest);

        Integer secondLargestNum = Arrays.stream(arr)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst().orElse(null);
        System.out.println("Second largest number is: " + secondLargestNum);

        for (int i : arr) {
            if (i < smallest) {
                smallest = i;
            } else if (i > largest) {
                largest = i;
            }
        }
        System.out.println("Smallest number is: " + smallest);
    }
}