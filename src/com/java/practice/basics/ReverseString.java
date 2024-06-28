package com.java.practice.basics;

import java.util.Scanner;

public class ReverseString {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String");

        String s = sc.next();
        String s1 = "";
        String s2 = "";

        char c;

        System.out.print("Original String :" + s + "\nReverse String :");

        for (int i = s.length() - 1; i >= 0; i--) {
            c = s.charAt(i);
            s1 = s1 + c;
        }

        System.out.print(s1);

        System.out.println("\n");

        if (s.equals(s1)) {
            System.out.println("Same String");
        } else {
            System.out.println("Does not match String");
        }

        System.out.println("---------------------------------------------------");
        System.out.println("Reverse String  by toCharArray() method of string....");

        char[] ch = s.toCharArray();

        for (int i = ch.length - 1; i >= 0; i--) {
            s2 = s2 + ch[i];
        }

        System.out.println(s2);
    }
}