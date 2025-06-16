package com.java.practice.basics;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringDemo {

    public static void main(String[] args) {

        String s1 = "my name is avinash";
        String[] words = s1.split("\\s");//splits the string based on string
        String name;
        System.out.println(s1);

        for (String w : words) {
            char[] c = w.toCharArray();
            name = String.valueOf(c[0]).toUpperCase() + w.substring(1);
            System.out.print(name + " ");
        }

        System.out.println("\n-------------------------");

        String collect = Stream.of(s1)
                .map(x -> new StringBuilder(x).reverse().toString())
                .collect(Collectors.joining(" "));
        System.out.println(collect);

        System.out.println("\n-------------------------");

        StringBuilder reversed = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i != 0) {
                reversed.append(" ");
            }
        }
        String result = reversed.toString();

        result = result.substring(0, 1).toUpperCase() + result.substring(1);
        System.out.println(result);

        System.out.println("\n-------------------------");
        String s11 = "InterviewBit";
        String s2 = s11;

        System.out.println(s11 == s2); //they are equal

        s11 += "Scaler";

        System.out.println(s11 == s2); //not equal

    }
}