package com.java.practice.interviewqna;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test21042025 {

    public static void main(String[] args) {

        List<String> fruits = List.of("apple", "banana", "Orange", "grapes", "umbrella"); // Orange // a,e,i,o

        // filter with lowerCase vowels -> if found make to upperCase
        List<String> vowelsStartStr = fruits.stream()
                .filter(fruit -> "aeiou".indexOf(fruit.charAt(0)) != -1)
                .map(String::toUpperCase)
                .toList();

        System.out.println("Vowels Start String: " + vowelsStartStr);

        // find 2nd highest unique num.. skip duplicate numbers
        List<Integer> nums = List.of(12, 34, 5, 67, 34, 89, 43, 67, 43);  // 67

        Integer secondHighestUniqueNum = nums.stream()
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet() // unique nums
                .stream()
                .filter(x -> x.getValue() == 1)
                .map(Map.Entry::getKey)
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(null);

        System.out.println("Second Highest Unique Num by removing duplicate num: " + secondHighestUniqueNum);

        Set<Integer> hs = new HashSet<>(nums);

        Integer uniqueNum = hs.stream()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(null);

        System.out.println("Second Highest duplicate num: " + uniqueNum);
    }
}