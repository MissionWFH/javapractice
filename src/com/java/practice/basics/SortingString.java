package com.java.practice.basics;

import java.util.Set;
import java.util.TreeSet;

public class SortingString {

    public static void main(String[] args) {

        String name = "Avinash Walke";

        Set<Character> sort = new TreeSet<Character>();
        char[] c1 = null;
        char c = 0;

        for (int i = 0; i < name.length(); i++) {
            c1 = name.toCharArray();
            sort.add(c1[i]);

            c = name.charAt(i);
            sort.add(c);
        }
        System.out.println(c);
        // Collections.sort(sort);
        System.out.println(sort);

        for (Character s : sort)
            System.out.print(s + ",");
    }
}