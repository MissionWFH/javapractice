package com.java.practice.dsa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaxSumOfSubArrayOfKSize {

    public static void main(String[] args) {
        int[] array = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println(maxSumSubarray(array, k));
    }

    public static int maxSumSubarray(int[] arr, int k) {
        // If the array is smaller than the window size
        if (arr.length < k) {
            System.out.println("Invalid input: Array size is smaller than the window size.");
            return -1;
        }

        // Calculate the sum of the first window of size k
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        // Initialize maxSum with the sum of the first window
        int maxSum = windowSum;

        // Slide the window across the array, updating the window sum
        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - k];  // Add next element and remove first element of previous window
            maxSum = Math.max(maxSum, windowSum);  // Update maxSum if new windowSum is greater
        }

        return maxSum;
    }

    public static List<Integer> firstNegativeNumberFromSubarray(int[] arr, int k) {
        List<Integer> result = new ArrayList<>();
        int start = 0, end = 0;
        Queue<Integer> negatives = new LinkedList<>();

        while (end < arr.length) {
            if (arr[end] < 0) {
                negatives.add(arr[end]);
            }
            if (end - start + 1 == k) {
                result.add(negatives.isEmpty() ? 0 : negatives.peek());
                if (arr[start] < 0 && !negatives.isEmpty() && arr[start] == negatives.peek()) {
                    negatives.poll();
                }
                start++;
            }
            end++;
        }
        return result;
    }

}
