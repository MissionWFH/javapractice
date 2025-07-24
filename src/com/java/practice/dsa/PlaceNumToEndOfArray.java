package com.java.practice.dsa;

import java.util.Arrays;

public class PlaceNumToEndOfArray {

    public static void main(String[] args) {
        int[] array = {8, 6, 1, 3, 1, 5, 1, 7};

       // extracted(array);
        System.out.println(Arrays.toString(array));

        optimalApproach(array);
        System.out.println(Arrays.toString(array));
    }

    private static void optimalApproach(int[] array) {
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 1) {
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;
                j++;
            }
        }
    }

    private static void extracted(int[] arr) {
        int index = 0;

        for (int num : arr) {
            if (num != 1) {
                arr[index++] = num;
            }
        }

        while (index < arr.length) {
            arr[index++] = 1;
        }
    }
}