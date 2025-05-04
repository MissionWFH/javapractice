package com.java.practice.basics;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AnagramString {

    private static boolean isAnagramUsingArrays(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();

        Arrays.sort(ch1);
        Arrays.sort(ch2);

        return Arrays.equals(ch1, ch2);
    }

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
        return anagramMap.values()
                .stream()
                .allMatch(x -> x == 0);
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
        System.out.println(isAnagramUsingArrays("keep", "peek"));
        System.out.println(isAnagramUsingArrays("listen", "silent"));
        System.out.println(isAnagramUsingArrays("tea", "eat"));
        System.out.println(isAnagramUsingArrays("gram", "jmrg"));
        System.out.println("------------------------------------------");
        System.out.println(isAnagramUsingOptimisedWayHashMap("keep", "peek"));
        System.out.println(isAnagramUsingOptimisedWayHashMap("listen", "silent"));
        System.out.println(isAnagramUsingOptimisedWayHashMap("tea", "eat"));
        System.out.println(isAnagramUsingOptimisedWayHashMap("gram", "jmrg"));
        System.out.println("------------------------------------------");
        System.out.println(isAnagramUsingHashMap("keep", "peek"));
        System.out.println(isAnagramUsingHashMap("listen", "silent"));
        System.out.println(isAnagramUsingHashMap("tea", "eat"));
        System.out.println(isAnagramUsingHashMap("gram", "jmrg"));
    }
}