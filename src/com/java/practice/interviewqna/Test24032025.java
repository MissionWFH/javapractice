package com.java.practice.interviewqna;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test24032025 {
    public static void main(String[] args) {
//        How to find duplicate elements in a given integers list in java using Stream functions?
//                10,15,8,49,25,98,98,32,15

        List<Integer> numbers = List.of(10, 15, 8, 49, 25, 98, 98, 32, 15);

        List<Integer> list = numbers.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() > 1)
                .map(x -> x.getKey())
                .toList();

        System.out.println(list);

        String s = "India";
        String s1 = new String("My India");
        s = "123";
        String s3 = s;
        System.out.println(s3);
    }
}
