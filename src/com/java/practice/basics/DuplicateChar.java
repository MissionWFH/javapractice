package com.java.practice.basics;


public class DuplicateChar {

    public static String removeDuplicateChar(String name) {
        String rev = "";

        for (int i = 0; i < name.length(); i++) {
            boolean found = false;

            for (int j = 0; j < rev.length(); j++) {

                if (name.charAt(i) == rev.charAt(j)) {
                    found = true;
                    System.out.println(name.charAt(i));
                    // break;
                }
            }
            if (!found) {
                rev = rev.concat(String.valueOf(name.charAt(i)));
            }
        }
        System.out.println(rev);

        return rev;
    }

    public static void main(String[] args) {

        String s = "AvinashWalke";
        String name = s.toLowerCase();
        removeDuplicateChar(name);
    }
}