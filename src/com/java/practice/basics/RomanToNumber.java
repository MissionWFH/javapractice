package com.java.practice.basics;

import java.util.HashMap;
import java.util.Map;

public class RomanToNumber {
    public static void main(String[] args) {
        System.out.println(romanToInt("III")); // 3
        System.out.println(romanToInt("IV"));  // 4
        System.out.println(romanToInt("IX"));  // 9
        System.out.println(romanToInt("X"));   // 10
    }

    public static int romanToInt(String romanStr) {
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);

        int result = 0;
        int prevValue = 0;

        for (int i = romanStr.length() - 1; i >= 0; i--) {
            int currentValue = romanMap.get(romanStr.charAt(i));
            if (currentValue < prevValue) {
                result -= currentValue;
            } else {
                result += currentValue;
            }
            prevValue = currentValue;
        }
        return result;
    }
}