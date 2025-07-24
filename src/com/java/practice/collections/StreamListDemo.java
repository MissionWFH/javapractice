package com.java.practice.collections;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamListDemo {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println("-------------------------------------------------------");
        list.forEach(num -> System.out.println(num + " " + Thread.currentThread().getName()));
        System.out.println("-------------------------------------------------------");

        list.parallelStream().forEach(num -> System.out.println(num + " " + Thread.currentThread().getName()));
        System.out.println("-------------------------------------------------------");

        List<String> nameList = new ArrayList<>();
        nameList.add("abc");
        nameList.add("lmdfl");
        nameList.add("ete");
        nameList.add("dfg");
        nameList.add("kfjfh");

        System.out.println(nameList);
        List<String> upperCaseList = nameList.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(upperCaseList);

        List<Integer> list3 = Arrays.asList(1, 3, 5, 7, 9);
        List<Integer> list4 = Arrays.asList(2, 4, 6, 8, 10);
        List<Integer> mergedList = Stream.concat(list3.stream(), list4.stream())
                .sorted()
                .collect(Collectors.toList());
        System.out.println(mergedList);
        System.out.println("-------------------------------------------------------");

        // Stream reduce() use cases with diff implementation
        List<Integer> numList = List.of(1, 2, 3, 4, 5);

        // use reduce() with BinaryOperator
        int reduceBinaryOperator = numList.stream().reduce(Integer::sum).get();

        // Use reduce() with an Identity(initial) value and BinaryOperator
        int reduceIdentityAndBinaryOperator = numList.stream().reduce(2, (a, b) -> a + b);

        System.out.println("reduceBinaryOperator " + reduceBinaryOperator);
        System.out.println("reduceIdentityAndBinaryOperator " + reduceIdentityAndBinaryOperator);

        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(3, 4, 5, 6, 7);
        List<Integer> intersection = list1.stream()
                .filter(list2::contains)
                .collect(Collectors.toList());

        System.out.println(intersection);

        List<Integer> numbers = List.of(5, 2, 8, 3, 7);
        Map<String, Integer> minMax = numbers.stream()
                .collect(Collectors.teeing(
                        Collectors.minBy(Integer::compareTo),
                        Collectors.maxBy(Integer::compareTo),
                        (min, max) -> {
                            Map<String, Integer> result = new HashMap<>();
                            result.put("min", min.get());
                            result.put("max", max.get());
                            return result;
                        }
                ));
        System.out.println(minMax);

    }
}