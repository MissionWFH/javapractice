package com.java.practice.basics;

public class StringDemo {

    public static void main(String[] args) {

        String s1 = "java string split method by javatpoint";
        String[] words = s1.split("\\s");//splits the string based on string
        //using java foreach loop to print elements of string array

        System.out.println(s1);

        for (String w : words) {
            char[] c = w.toCharArray();

            String f = String.valueOf(c[0]).toUpperCase();
            String l = w.substring(1, w.length());
            System.out.print((f + l) + " ");
//			System.out.print(w+" ");

        }

        System.out.println("\n-------------------------");

        for (String w : words) {
            String r = "";
            for (int i = w.length() - 1; i >= 0; i--) {
                r += w.charAt(i);
            }
            System.out.print(r + " ");
        }
        System.out.println("\n-------------------------");
        String s11 = "InterviewBit";
        String s2 = s11;

        System.out.println(s11 == s2); //they are equal

        s11 += "Scaler";

        System.out.println(s11 == s2); //not equal

    }
}