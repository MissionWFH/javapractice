package com.java.practice.basics;

import java.util.Scanner;

public class ReverseString {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String");

        String input = sc.next();
        String s2 = "";

        StringBuilder revStr = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            revStr.append(input.charAt(i));
        }

        if (input.equals(revStr.toString())) {
            System.out.println("given input is palindrome");
        } else {
            System.out.println("given input is not palindrome");
        }

        System.out.println("---------------------------------------------------");
        System.out.println("Reverse String  by toCharArray() method of string....");

        char[] ch = input.toCharArray();

        for (int i = ch.length - 1; i >= 0; i--) {
            s2 = s2 + ch[i];
        }
        System.out.println(s2);
    }
}