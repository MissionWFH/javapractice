package com.java.practice.basics;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringDemo {

    public static void main(String[] args) {

        String s1 = "my name is avinash";
        String[] words = s1.split("\\s");//splits the string based on string
        //using java foreach loop to print elements of string array

        System.out.println(s1);

        for (String w : words) {
            char[] c = w.toCharArray();

            String f = String.valueOf(c[0]).toUpperCase();
            String l = w.substring(1, w.length());
            System.out.print((f + l) + " ");
//			System.out.print(w+" ");

        }

        System.out.println("\n-------------------------");

        String collect = Stream.of(s1)
                .map(x -> new StringBuilder(x).reverse().toString())
                .collect(Collectors.joining(" "));
        System.out.println(collect);

        System.out.println("\n-------------------------");
        String s11 = "InterviewBit";
        String s2 = s11;

        System.out.println(s11 == s2); //they are equal

        s11 += "Scaler";

        System.out.println(s11 == s2); //not equal

    }
}