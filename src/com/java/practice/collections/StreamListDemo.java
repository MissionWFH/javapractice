package com.java.practice.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamListDemo {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println("------------------------------------");
        list.stream().forEach(num -> System.out.println(num + " " + Thread.currentThread().getName()));
        System.out.println("------------------------------------");
        list.parallelStream().forEach(num -> System.out.println(num + " " + Thread.currentThread().getName()));
        System.out.println("------------------------------------");
        System.out.println(list);
        List<Integer> list2 = list.stream().map(num -> num * num).collect(Collectors.toList());
        System.out.println(list2);

        List<String> nameList = new ArrayList<>();
        nameList.add("abc");
        nameList.add("lmdfl");
        nameList.add("ete");
        nameList.add("dfg");
        nameList.add("kfjfh");

        System.out.println(nameList);
        List<String> finalList = nameList.stream().map(name -> name.toUpperCase()).collect(Collectors.toList());
        System.out.println(finalList);
    }
}