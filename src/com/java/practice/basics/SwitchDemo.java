package com.java.practice.basics;

import java.util.Scanner;

public class SwitchDemo {

    public static void main(String[] args) {
        System.out.println("Enter any number to conver alphabetical order.");

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        switch (num) {
            case 1:
                System.out.println(num + " = A");
                break;
            case 2:
                System.out.println(num + " = B");
                break;
            case 3:
                System.out.println(num + " = C");
                break;
            case 4:
                System.out.println(num + " = D");
                break;
            case 5:
                System.out.println(num + " = E");
                break;
            case 6:
                System.out.println(num + " = F");
                break;
            case 7:
                System.out.println(num + " = G");
                break;
            case 8:
                System.out.println(num + " = H");
                break;
            case 9:
                System.out.println(num + " = I");
                break;
            case 10:
                System.out.println(num + " = J");
                break;
            default:
                System.out.println("Sorry we can performing upto 10 digit only.\nYou entered number is greater than 10");
        }

    }

}
