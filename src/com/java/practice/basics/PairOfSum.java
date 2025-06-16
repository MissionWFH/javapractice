package com.java.practice.basics;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class PairOfSum {

    public static void main(String[] args) {
        List<Integer> nums = List.of(2, 4, 3, 5, 7, 8, 1, 6);
        int[] arrNum = new int[]{2, 4, 3, 5, 7, 8, 1, 6};

        findPairs(arrNum, 9);
        System.out.println("------------------------------");
        findPairs2(nums, 9);
        System.out.println("------------------------------");
        int[] twoSum = getTwoSum(arrNum, 9);
        System.out.println("Two sum of given " + Arrays.deepToString(Arrays.stream(arrNum).boxed().toArray()));
        System.out.println("Index's: " + twoSum[0] + " " + twoSum[1]);
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

    public static int[] getTwoSum(int[] numbers, int target) {
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
}
