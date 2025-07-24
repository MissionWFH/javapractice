package com.java.practice.dsa;

import java.util.HashMap;
import java.util.Map;

public class AnagramCountOccurrence {

    public static void main(String[] args) {
        int count = countAnagrams("qcabcbaebabacd", "abc");
        int count1 = countAnagrams1("qcabcbaebabacd", "abc");
        System.out.println(count);
        System.out.println(count1);
    }

    public static int countAnagrams(String text, String pattern) {
        // Map to store the frequency of each character in the pattern
        Map<Character, Integer> patternMap = new HashMap<>();
        // Build the frequency map for the pattern string
        for (int i = 0; i < pattern.length(); i++) {
            Character currentChar = pattern.charAt(i);
            // If the character is already in the map, increment its count
            patternMap.put(currentChar, patternMap.getOrDefault(currentChar, 0) + 1);
        }
        int startIndex = 0; // Start of the sliding window
        int endIndex = 0;   // End of the sliding window
        int counter = patternMap.size(); // Number of unique characters in the pattern to match
        int result = 0;     // To store the count of anagram matches
        // Start sliding the window over the text
        while (endIndex < text.length()) {
            // Current character at the end of the window
            Character currentCharInText = text.charAt(endIndex);
            // If the character is in the pattern, update its count in the map
            if (patternMap.containsKey(currentCharInText)) {
                patternMap.put(currentCharInText, patternMap.get(currentCharInText) - 1);
                // If the character count becomes zero, it means it's fully matched
                if (patternMap.get(currentCharInText) == 0) {
                    counter--;
                }
            }
            // Expand the window until it matches the length of the pattern
            if (endIndex - startIndex + 1 < pattern.length()) {
                endIndex++;
            }
            // When the window size matches the length of the pattern
            else if ((endIndex - startIndex + 1) == pattern.length()) {
                // If counter is 0, it means the current window is an anagram of the pattern
                if (counter == 0) {
                    result++;
                }

                // Now, slide the window to the right by removing the leftmost character
                if (patternMap.containsKey(text.charAt(startIndex))) {
                    // If the leftmost character is leaving and its count was zero, increment the counter
                    if (patternMap.get(text.charAt(startIndex)) == 0) {
                        counter++;
                    }
                    // Restore the count of the character that is sliding out
                    patternMap.put(text.charAt(startIndex), patternMap.get(text.charAt(startIndex)) + 1);
                }

                // Move the window forward
                startIndex++;
                endIndex++;
            }
        }

        // Return the total count of anagram matches
        return result;
    }

    public static int countAnagrams1(String txt, String pat) {
        int n = txt.length();
        int k = pat.length();
        if (k > n) return 0;

        Map<Character, Integer> patternMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();

        // Build pattern map and initial window map
        for (int i = 0; i < k; i++) {
            patternMap.put(pat.charAt(i), patternMap.getOrDefault(pat.charAt(i), 0) + 1);
            windowMap.put(txt.charAt(i), windowMap.getOrDefault(txt.charAt(i), 0) + 1);
        }

        int count = 0;
        if (patternMap.equals(windowMap)) count++;

        for (int i = k; i < n; i++) {
            char prevChar = txt.charAt(i - k);
            char currChar = txt.charAt(i);

            // Remove count of previous char
            windowMap.put(prevChar, windowMap.get(prevChar) - 1);
            if (windowMap.get(prevChar) == 0) {
                windowMap.remove(prevChar);
            }

            // Add count of current char
            windowMap.put(currChar, windowMap.getOrDefault(currChar, 0) + 1);

            if (patternMap.equals(windowMap)) count++;
        }

        return count;
    }
}
