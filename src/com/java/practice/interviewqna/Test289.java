package com.java.practice.interviewqna;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
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
    }
}
