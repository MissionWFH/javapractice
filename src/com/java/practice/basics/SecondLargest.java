package com.java.practice.basics;

public class SecondLargest {

    public static void main(String[] args) {

        int arr[] = {14, 46, 47, 86, 82};

        int largest = arr[0];
        int secondLargest = arr[0];
        int smallest = arr[0];

        System.out.println("The given array is:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
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