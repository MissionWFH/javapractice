package com.java.practice.interviewqna.oracle;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test13062025 {

    public static void main(String[] args) {

        List<String> list = List.of("abc", "abcd", "abc");
        String sum = list.stream()
                .flatMapToInt(String::chars)
                .distinct()
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(","));
        System.out.println(sum);

        int[] arr = {2, 3, 5, 7, 1, 9, 0};
        int target = 7;
        int[] targetPair = getTargetedPairs(arr, target);
        Stream.of(targetPair).forEach(pair -> System.out.println(pair[0] + " " + pair[1]));

        String s = "abcabcabcef";
        String collect = s.chars()
                .mapToObj(c -> (char) c)
                .distinct()
                .map(String::valueOf)
                .collect(Collectors.joining());
        System.out.println(collect);

        Set<Character> set = new HashSet<>();
        String temp = "";
        String longestUniqueStr = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                temp = "";
                set.clear();
            }
            set.add(c);
            temp += c;
            if (temp.length() > longestUniqueStr.length()) {
                longestUniqueStr = temp;
            }
        }
        System.out.println(longestUniqueStr);
    }

    private static int[] getTargetedPairs(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int delta = target - arr[i];
            if (map.containsKey(delta)) {
                return new int[]{map.get(delta), i};
            }
            map.put(arr[i], i);
        }
        return new int[]{-1, -1};
    }
}