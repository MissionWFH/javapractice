package com.java.practice.dsa;

public class ReverseVowels {

    private static boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) < 0;
    }

    public static String reverseVowels(String s) {

        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;

        while (left < right) {
            // Move left pointer until a vowel is found
            while (isVowel(chars[left])) {
                left++;
            }
            // Move right pointer until a vowel is found
            while (isVowel(chars[right])) {
                right--;
            }

            // If both pointers found vowels, swap them
            if (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(reverseVowels("hello"));
    }
}