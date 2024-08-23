package com.java.practice.basics;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicateChar {

    public static String removeDuplicateChar(String name) {
        String rev = "";

        for (int i = 0; i < name.length(); i++) {
            boolean found = false;

            for (int j = 0; j < rev.length(); j++) {

                if (name.charAt(i) == rev.charAt(j)) {
                    found = true;
                    System.out.println(name.charAt(i));
                    // break;
                }
            }
            if (!found) {
                rev = rev.concat(String.valueOf(name.charAt(i)));
            }
        }
        System.out.println(rev);

        return rev;
    }

    public static void main(String[] args) {

        String input = "aarvi";
        String name = input.toLowerCase();
        //removeDuplicateChar(name);

        System.out.println("Original input: " + name);

        Map<String, Long> charOccurrenceCount = Arrays.stream(name.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Char Occurrence count: " + charOccurrenceCount);

        List<Map.Entry<String, Long>> duplicateCharCount = Arrays.stream(name.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() >= 2)
                .collect(Collectors.toList());
        System.out.println("Duplicate Char count: " + duplicateCharCount);

        List<Map.Entry<String, Long>> uniqueCharCount = Arrays.stream(name.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() == 1)
                .collect(Collectors.toList());
        System.out.println("Unique Char count: " + uniqueCharCount);

        String nonRepeatFirstElement = Arrays.stream(name.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst().orElse(null);
        System.out.println("non-repeat First Element: " + nonRepeatFirstElement);
    }
}