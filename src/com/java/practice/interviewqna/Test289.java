package com.java.practice.interviewqna;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test289 {
    public static void main(String[] args) {
        // 1-10 -> even -> *5 even (2,4,6,8,10)
        IntStream range = IntStream.range(1, 11);

        List<Integer> collect = range.boxed().filter(x -> x % 2 == 0)
                .map(num -> num * 5).collect(Collectors.toList());

        System.out.println(collect);

        // hello world

        String name = "hello word";
        Map<String, Long> collect1 = Arrays.stream(name.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(collect1);

        System.out.println("Find Smallest Positive Number: " + findSmallestPositive(new int[]{3, 4, -1, 1, 3, 5})); // 2
        System.out.println("Find Smallest Positive Number: " + findSmallestPositive(new int[]{1, 2, 0}));     // 3
        System.out.println("Find Smallest Positive Number: " + findSmallestPositive(new int[]{-1, -2, -3}));  // 1
        System.out.println("Find Smallest Positive Number: " + findSmallestPositive(new int[]{7, 8, 9, 7}));     // 1
        System.out.println("Find Smallest Positive Number: " + findSmallestPositive(new int[]{1, 2, 3}));     // 4
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
}
