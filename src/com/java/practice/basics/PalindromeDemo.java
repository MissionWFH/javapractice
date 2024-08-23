package com.java.practice.basics;

import java.util.Scanner;

public class PalindromeDemo {

    public static void main(String[] args) {

        System.out.println("Enter number");
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int temp;
        int rev;
        int sum = 0;
        temp = num;

        while (num > 0) {
            rev = num % 10;
            sum = (sum * 10) + rev;
            num = num / 10;
        }
        System.out.println(sum);

        if (temp == sum) {
            System.out.println("Pallindrom num");
        } else {
            System.out.println("normal num");
        }
    }
}