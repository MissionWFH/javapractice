package com.java.practice.basics;

import java.util.HashMap;
import java.util.Map;

public class AnagramString {

    private static boolean isAnagramUsingOptimisedWayHashMap(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        Map<Character, Integer> anagramMap = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);

            anagramMap.put(c1, anagramMap.getOrDefault(c1, 0) + 1);
            anagramMap.put(c2, anagramMap.getOrDefault(c2, 0) - 1);
        }
        return anagramMap.containsValue(0);
    }

    private static boolean isAnagramUsingHashMap(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        Map<Character, Integer> map = new HashMap<>();

        for (char c : str1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : str2.toCharArray()) {
            if (!map.containsKey(c)) {
                return false;
            }
            map.put(c, map.get(c) - 1);
            if (map.get(c) == 0) {
                map.remove(c);
            }
        }
        return map.isEmpty();
    }

    public static void main(String[] args) {
        String s1 = "keep"; // listen
        String s2 = "peek"; // silent
        if (isAnagramUsingHashMap(s1, s2)) {
            System.out.println(s1 + " and " + s2 + " are anagrams using hashMap approach");
        } else {
            System.out.println(s1 + " and " + s2 + " are not anagrams using hashMap approach");
        }

        if (isAnagramUsingOptimisedWayHashMap(s1, s2)) {
            System.out.println(s1 + " and " + s2 + " are anagrams using optimised way hashMap approach");
        } else {
            System.out.println(s1 + " and " + s2 + " are not anagrams using optimised way hashMap approach");
        }
    }
}