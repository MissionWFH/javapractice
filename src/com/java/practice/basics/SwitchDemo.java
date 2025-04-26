package com.java.practice.basics;

import java.util.Scanner;

public class SwitchDemo {

    public static void main(String[] args) {

        System.out.println("Enter any number to convert alphabetical order.");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        switch (num) {
            case 1 -> System.out.println(num + " = A");
            case 2 -> System.out.println(num + " = B");
            case 3 -> System.out.println(num + " = C");
            case 4 -> System.out.println(num + " = D");
            case 5 -> System.out.println(num + " = E");
            case 6 -> System.out.println(num + " = F");
            case 7 -> System.out.println(num + " = G");
            case 8 -> System.out.println(num + " = H");
            case 9 -> System.out.println(num + " = I");
            case 10 -> System.out.println(num + " = J");
            default ->
                    System.out.println("Sorry we can performing upto 10 digit only.\nYou entered number is greater than 10");
        }
    }
}