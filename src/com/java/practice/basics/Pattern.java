package com.java.practice.basics;

public class Pattern {

    public static void main(String[] args) {

        for (int i = 1; i <= 5; i++) {                            // *
            for (int j = 1; j <= i; j++) {                        // **
                System.out.print("*");                        // ***
            }                                                // ****
            System.out.print("\n");                            // *****
        }
        System.out.println("------------------------");

        for (int i = 5; i > 0; i--) {                                // *****
            for (int j = 1; j <= i; j++) {                            // ****
                System.out.print("*");                        // ***
            }                                                // **
            System.out.print("\n");                            // *
        }
        System.out.println("------------------------");

        for (int i = 1; i <= 5; i++) {                            // 1
            for (int j = 1; j <= i; j++) {                        // 12
                System.out.print(j);                        // 123
            }                                                // 1234
            System.out.print("\n");                            // 12345
        }
        System.out.println("------------------------");

        for (int i = 5; i > 0; i--) {                                // 12345
            for (int j = 1; j <= i; j++) {                            // 1234
                System.out.print(j);                        // 123
            }                                                // 12
            System.out.print("\n");                            // 1
        }
        System.out.println("------------------------");

        for (int i = 1; i <= 5; i++) {                            // 1
            for (int j = 1; j <= i; j++) {                        // 22
                System.out.print(i);                        // 333
            }                                                // 4444
            System.out.print("\n");                            // 55555
        }
        System.out.println("------------------------");

        for (int i = 5; i > 0; i--) {                                // 55555
            for (int j = 1; j <= i; j++) {                            // 4444
                System.out.print(i);                        // 333
            }                                                // 22
            System.out.print("\n");                            // 1
        }
        System.out.println("------------------------");

    }

}
