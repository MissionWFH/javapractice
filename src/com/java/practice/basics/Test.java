package com.java.practice.basics;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    static Scanner console = new Scanner(System.in);

    public static void getFactorial() {
        int fact = 1, flag = 0;
        List<Integer> list = new ArrayList<Integer>();

        for (int i = 1; i <= 10; i++) {
            fact = fact * i;
            list.add(fact);
        }
        System.out.println("Enter number to cheack is it in factorial series or not ?");
        int num = console.nextInt();

        for (int i : list) {
            if (num == i) {
                System.out.println(num + " is in factorial series...");
                flag = 1;
            }
        }
        if (flag == 0) {
            System.out.println(num + " is not in factorial series...");
        }

    }

    public static void getFibonacci() {
        System.out.println("Get Fibonacci series upto ? e.g 11,16,23 ");
        int n = console.nextInt();

        if (n > 1) {
            System.out.println("The Fibonacci numbers less than " + n + " are: ");
            System.out.print("1, 1, ");
            int f2 = 1;
            int fibonacci = 1;

            for (int i = 1; i + f2 <= n; ) {
                fibonacci = i + f2;
                i = f2;
                f2 = fibonacci;
                System.out.print(fibonacci + ", ");
            }
        } else {
            System.out.println("There are no numbers less than " + n + " in the series");
        }
    }


    public static void main(String[] args) {
        System.out.println("---------- Factorial Demo ------------");
        getFactorial();
        System.out.println("--------------------------------------");
        System.out.println("---------- Fibonacci Demo ------------");
        getFibonacci();

    }
}
