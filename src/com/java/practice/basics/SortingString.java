package com.java.practice.basics;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SortingString {

    public static void main(String[] args) {

        String name = "avinash walke";
        System.out.println("Original String: " + name);
        String sortedString = Arrays.stream(name.split("")).sorted().collect(Collectors.joining());
        System.out.println("Sorted String: " + sortedString);
    }
}