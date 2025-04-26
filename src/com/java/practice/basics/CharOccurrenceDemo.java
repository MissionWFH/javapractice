package com.java.practice.basics;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharOccurrenceDemo {

    public static void main(String[] args) {

        String input = "aarvi";
        String name = input.replaceAll("\\s+", "").toLowerCase();

        System.out.println("Original input: " + name);

        String afterDuplicateChar = Arrays.stream(name.split(""))
                .distinct()
                .collect(Collectors.joining());
        System.out.println("After removing duplicate char: " + afterDuplicateChar);

        Map<String, Long> charOccurrenceCount = Arrays.stream(name.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Char Occurrence count: " + charOccurrenceCount);

        List<Map.Entry<String, Long>> duplicateCharCount = Arrays.stream(name.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() >= 2)
                .sorted(Comparator.comparingLong(Map.Entry::getValue))
                .collect(Collectors.toList());
        System.out.println("Duplicate Char count: " + duplicateCharCount);

        List<Map.Entry<String, Long>> uniqueCharCount = Arrays.stream(name.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() == 1)
                .collect(Collectors.toList());
        System.out.println("Unique Char count: " + uniqueCharCount);

        String nonRepeatFirstChar = Arrays.stream(name.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst().orElse(null);
        System.out.println("Non-repeat first char: " + nonRepeatFirstChar);

        String maximumRepeatChar = Arrays.stream(name.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse(null);
        System.out.println("Maximum repeat char: " + maximumRepeatChar);

        String minimumRepeatChar = Arrays.stream(name.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .min(Comparator.comparingLong(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse(null);
        System.out.println("Minimum repeat char: " + minimumRepeatChar);

        String nTHChar = Arrays.stream(name.split(""))
                .skip(2) // skip (N-1) to get requested char
                .findFirst()
                .orElse(null);
        System.out.println("First 3rd char: " + nTHChar);

        List<String> list = List.of("ASD", "QWE");

        List<Character> list1 = list.stream()
                .flatMap(s -> s.chars().mapToObj(c -> (char) c))
                .toList();
        System.out.println(list1);

        List<String> strings = Arrays.asList("apple", "banana", "orange", "grape", "melon");
        char target = 'a';
        long occurrences = strings.stream()
                .flatMapToInt(CharSequence::chars)
                .filter(c -> c == target)
                .count();
        System.out.println("Occurrences of '" + target + "': " + occurrences);
    }
}