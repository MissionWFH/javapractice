package com.java.practice.dsa;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingChar {

    public static void main(String[] args) {
        String s = "abcdeeefghijaabc";
        System.out.println(lengthOfLongestSubstring(s)); // Output: 3
    }

    private static String lengthOfLongestSubstring(String str) {
        if(str == null || str.isEmpty()) {
            return "";
        }

        HashSet<Character> set = new HashSet<>();
        String temp = "";
        String longestUniqueStr = "";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (set.contains(ch)) {
                temp = "";
                set.clear();
            }
            set.add(ch);
            temp += ch;
            if (temp.length() > longestUniqueStr.length()) {
                longestUniqueStr = temp;
            }
        }
        return longestUniqueStr;
    }
}
