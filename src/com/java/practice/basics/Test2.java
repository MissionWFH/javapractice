package com.java.practice.basics;

import java.util.ArrayList;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        String s1 = new String("Avi");
        String s2 = new String("Avi");
        String s3 = s1;

        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        System.out.println(s1 == s3);
        System.out.println(s1.equals(s3));
        System.out.println("------------------------------------------");

        List<Object> list = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            list.add(i);
        }

        System.out.println("List size() : " + list.size());
        System.out.println(list.get(4));

        List<String> nameList = new ArrayList<>();
        nameList.add("Gorakh");
        nameList.add("Vimal");
        nameList.add("Kishor");
        nameList.add("Manisha");
        nameList.add("Sainath");
        nameList.add("Avinash");
        nameList.add("Dipali");

        nameList.stream().filter(name -> name.startsWith("A")).forEach(System.out::println);

    }
}