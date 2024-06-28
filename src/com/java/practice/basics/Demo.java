package com.java.practice.basics;

import java.util.Scanner;


class Demo {
    public static void main(String[] args) {
        int a, b;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two no.");
        a = sc.nextInt();
        b = sc.nextInt();
        System.out.print("a = " + a + " b = " + b);
        a = a + b;
        b = a - b;
        a = a - b;

        System.out.print("\na = " + a + " b = " + b);

    }
}