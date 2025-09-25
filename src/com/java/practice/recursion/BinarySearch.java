package com.java.practice.recursion;

import com.java.practice.basics.SearchElement;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    //Recursive method for binary search
    private static boolean binarySearch(int[] arr, int low, int high, int key) {

        int mid = (low + high) / 2;
        if (low > high)
            return false;

        if (arr[mid] == key)
            return true;

        if (key < arr[mid])
            return binarySearch(arr, low, mid - 1, key);

        return binarySearch(arr, mid + 1, high, key);
    }

    public static void main(String[] args) {

        int[] arr = SearchElement.getRandomNums();
        Arrays.sort(arr);
        System.out.println("Given Array: " + Arrays.toString(arr));
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter element to be search: ");
        int key = sc.nextInt();
        if (binarySearch(arr, 0, (arr.length - 1), key))
            System.out.println("Element Found. ");
        else
            System.out.println("Element not Found.");
    }
}