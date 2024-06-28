package com.java.practice.basics;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {

        String ans;
        Scanner sc = new Scanner(System.in);

        try {
            Calculatoins.operations();

            while (true) {

                System.out.println("\nDo you want to continue ? y/n ");

                ans = sc.next();
                System.out.println("------------------------------------------");

                if (ans.equalsIgnoreCase("Y")) {
                    Calculatoins.operations();
                } else {
                    System.out.println("Thank you !!!");
                    break;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("\nInvalid Choice....");
            System.out.println("please select above operation");
            System.out.println("------------------------------------------");
            Calculatoins.operations();
        }
    }
}