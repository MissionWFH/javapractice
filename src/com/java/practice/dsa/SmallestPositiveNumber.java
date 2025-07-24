package com.java.practice.dsa;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SmallestPositiveNumber {

    public static void main(String[] args) {
        System.out.println("Find Smallest Positive Number: " + solution(new int[]{3, 4, -1, 1, 3, 5})); // 2
        System.out.println("Find Smallest Positive Number: " + solution(new int[]{1, 2, 0}));     // 3
        System.out.println("Find Smallest Positive Number: " + solution(new int[]{-1, -2, -3}));  // 1
        System.out.println("Find Smallest Positive Number: " + solution(new int[]{7, 8, 9, 7}));     // 1
        System.out.println("Find Smallest Positive Number: " + solution(new int[]{1, 2, 3}));     // 4
    }

    public static int findSmallestPositive(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (num > 0)
                set.add(num);
        }

        int smallest = 1;
        while (set.contains(smallest)) {
            smallest++;
        }
        return smallest;
    }

    public static int solution(int[] arr) {
        Arrays.sort(arr);

        int smallest = 1;
        for (int j : arr) {
            if (j == smallest) {
                smallest++;
            }
        }
        return smallest;
    }
}
