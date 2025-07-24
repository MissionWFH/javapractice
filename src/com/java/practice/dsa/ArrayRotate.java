package com.java.practice.dsa;

import java.util.Arrays;

public class ArrayRotate {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        rotate(arr, 3);
    }

    public static void rotate(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k == 0) {
            return;
        }
        int n = arr.length;
        k %= n; // Handle cases where k is greater than n

        // 1. Reverse the first k elements
        reverse(arr, 0, k - 1);
        // 2. Reverse the remaining n-k elements
        reverse(arr, k, n - 1);
        // 3. Reverse the entire array
        reverse(arr, 0, n - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
