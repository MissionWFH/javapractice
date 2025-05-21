package com.java.practice.basics;

import java.util.List;
import java.util.stream.IntStream;

public class PairOfSum {

    public static void main(String[] args) {
        findPairs(List.of(2, 4, 3, 5, 7, 8, 1, 6), 9);
        findPairs2(List.of(2, 4, 3, 5, 7, 8, 1, 6), 9);
    }

    public static void findPairs(List<Integer> numbers, int targetSum) {
        IntStream.range(0, numbers.size())
                .boxed()
                .flatMap(i -> IntStream.range(i + 1, numbers.size())
                        .mapToObj(j -> new int[]{numbers.get(i), numbers.get(j)}))
                .filter(pair -> pair[0] + pair[1] == targetSum)
                .forEach(pair -> System.out.println("(" + pair[0] + ", " + pair[1] + ")"));
    }

    public static void findPairs2(List<Integer> numbers, int targetSum) {
        numbers.stream()
                .flatMap(i -> numbers.stream()
                        .filter(j -> i < j && i + j == targetSum)
                        .map(j -> List.of(i, j)))
                .forEach(System.out::println);
    }
}
