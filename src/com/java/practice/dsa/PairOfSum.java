package com.java.practice.dsa;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class PairOfSum {

    public static void main(String[] args) {
        List<Integer> nums = List.of(2, 4, 3, 5, 7, 8, 1, 2, 6);
        int[] arrNum = new int[]{2, 4, 3, 5, 7, 8, 1, 2, 6};
        int target = 9;
        System.out.println("Input Arr: " + Arrays.toString(arrNum) + "\nTarget: " + target);
        System.out.println("------------------------------");

        findPairs(arrNum, target);
        System.out.println("------------------------------");

        findPairs2(nums, target);
        System.out.println("------------------------------");

        int[] twoSum = getTwoSumIndex(arrNum, target);
        System.out.println("Two Sum Index's: " + twoSum[0] + " " + twoSum[1]);
        System.out.println("------------------------------");

        getPairsUsingTwoPointer(arrNum, target);
    }

    public static void findPairs(int[] numbers, int target) {
        IntStream.range(0, numbers.length)
                .boxed()
                .flatMap(i -> IntStream.range(i + 1, numbers.length)
                        .mapToObj(j -> new int[]{numbers[i], numbers[j]}))
                .filter(pair -> pair[0] + pair[1] == target)
                .forEach(pair -> System.out.println("(" + pair[0] + ", " + pair[1] + ")"));
    }

    public static void findPairs2(List<Integer> numbers, int target) {
        numbers.stream()
                .flatMap(i -> numbers.stream()
                        .filter(j -> i < j && i + j == target)
                        .map(j -> List.of(i, j)))
                .forEach(System.out::println);
    }

    public static int[] getTwoSumIndex(int[] numbers, int target) {
        Map<Integer, Integer> twoSumMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int delta = target - numbers[i];
            if (twoSumMap.containsKey(delta)) {
                return new int[]{twoSumMap.get(delta), i};
            }
            twoSumMap.put(numbers[i], i);
        }
        return new int[]{-1, -1};
    }

    public static void getPairsUsingTwoPointer(int[] numbers, int target) {
        Arrays.sort(numbers);  // Required for two-pointer
        int left = 0, right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                System.out.println("(" + numbers[left] + ", " + numbers[right] + ")");
                left++;
                right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
    }
}
