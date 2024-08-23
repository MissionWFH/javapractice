package com.java.practice.basics;

import java.util.Scanner;

public class PrimeNum {

    public static void main(String[] args) {

        System.out.println("Enter num to check whether it is prime or not...");
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int temp = 0;
        int flag = 0;
        int i;
        temp = num / 2;

        for (i = 2; i <= temp; i++) {
            if (num % i == 0) {
                System.out.println("it is not prime number."); //4 6 8 9 10 12 14 15 16
                flag = 1;
                break;
            }
        }
        if (flag == 0)
            System.out.println("prime number..."); //2 3 5 7 11 13 17
    }
}