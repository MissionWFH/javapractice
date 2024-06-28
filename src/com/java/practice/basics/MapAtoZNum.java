package com.java.practice.basics;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapAtoZNum {

    public static void main(String[] args) {
        strToNum();
    }

    public static void strToNum() {
        String str = "abcdefghijklmnopqrstuvwxyz";
        Map<Character, Integer> AtoZNum = new HashMap<>();
        int counter = 1;

        for (int i = 0; i < str.length(); i++) {
            AtoZNum.put(str.charAt(i), counter++);
        }

        System.out.println(AtoZNum + "\n");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name to display alphanumeric number");
        String name = sc.nextLine();

        for (int j = 0; j < name.length(); j++) {
            System.out.print(AtoZNum.get(name.charAt(j)) + " ");
        }
    }
}