package com.java.practice.interviewqna;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test219 {

    public static void main(String[] args) {
        List<String> cities = Arrays.asList("cHeNNai", "muMbai", "deLHI", "muMBai");

        List<String> collect1 = cities.stream()
                .map(String::toLowerCase)
                .map(str1 -> str1.substring(0, 1).toUpperCase() + str1.substring(1))
                .collect(Collectors.toList());
        System.out.println(collect1);

        Map<String, Long> collect2 = collect1.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect2);

        //1. Convert each string in camel case , e.g {"Chennai", "Mumbai", "Delhi", "Mumbai"}
        //2. Find the occurency of strings , e.g. Chennai-1, Delhi-1, Mumbai-2 -> DOne
    }
}