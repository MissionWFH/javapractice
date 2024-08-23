package com.java.practice.basics;

import java.util.Scanner;

public class Calculations {

    int a;
    int b;
    int c;
    int choice;

    public void operations() {

        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.println("                  Calculator                  ");
        System.out.println("------------------------------------------");

        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Modulo");
        System.out.println("6. Square");
        System.out.println("7. Cubes");
        System.out.println("8. Trigonometry operations...");
        System.out.println("------------------------------------------");

        System.out.println("\nEnter your choice...");

        choice = sc.nextInt();

        System.out.println("------------------------------------------");

        switch (choice) {
            case 1:
                System.out.println("Enter two numbers: ");
                a = sc.nextInt();
                b = sc.nextInt();
                c = a + b;
                System.out.println("Addtion of two numbers is: " + c);
                System.out.println("------------------------------------------");

                break;

            case 2:
                System.out.println("Enter two numbers: ");
                a = sc.nextInt();
                b = sc.nextInt();
                c = a - b;
                System.out.println("Subtration of two numbers is: " + c);
                System.out.println("------------------------------------------");

                break;

            case 3:
                System.out.println("Enter two numbers: ");
                a = sc.nextInt();
                b = sc.nextInt();
                c = a * b;
                System.out.println("Multiplication of two numbers is: " + c);
                System.out.println("------------------------------------------");

                break;

            case 4:
                System.out.println("Enter two numbers: ");
                a = sc.nextInt();
                b = sc.nextInt();
                c = a / b;
                System.out.println("Division of two numbers is: " + c);
                System.out.println("------------------------------------------");

                break;

            case 5:
                System.out.println("Enter two numbers: ");
                a = sc.nextInt();
                b = sc.nextInt();
                c = b % a;
                System.out.println("Modulo of two numbers is: " + c);
                System.out.println("------------------------------------------");

                break;

            case 6:
                System.out.println("Enter one numbers: ");
                a = sc.nextInt();
                c = a * a;
                System.out.println("Square of " + a + " is: " + c);
                System.out.println("------------------------------------------");

                break;

            case 7:
                System.out.println("Enter one numbers: ");
                a = sc.nextInt();
                c = a * a * a;
                System.out.println("Cube of " + a + " numbers is: " + c);
                System.out.println("------------------------------------------");

                break;

            case 8:
                System.out.println("1. sin()");
                System.out.println("2. cos()");
                System.out.println("3. tan()");
                System.out.println("select trignometric opertaion...");
                System.out.println("------------------------------------------");

                choice = sc.nextInt();

                double s, c, t, s1, c1, t1;
                System.out.println("------------------------------------------");

                switch (choice) {
                    case 1:
                        System.out.println("Enter angle for sin():");
                        s = sc.nextDouble();
                        s1 = Math.sin(s);
                        System.out.println("sin(" + s + ") : " + s1);
                        System.out.println("------------------------------------------");
                        break;

                    case 2:
                        System.out.println("Enter angle for cos():");
                        c = sc.nextDouble();
                        c1 = Math.cos(c);
                        System.out.println("cos(" + c + ") : " + c1);
                        System.out.println("------------------------------------------");
                        break;

                    case 3:
                        System.out.println("Enter angle for tan(): ");
                        t = sc.nextDouble();
                        t1 = Math.tan(t);
                        System.out.println("tan(" + t + ") : " + t1);
                        System.out.println("------------------------------------------");
                        break;
                }
                break;

            default:
                System.out.println("\nInvalid Choice....");
                System.out.println("please select above operation");
                System.out.println("------------------------------------------");
                break;
        }
    }
}