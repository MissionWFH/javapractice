package com.java.practice.basics;

public class TableTest {

    public static void main(String[] args) {
        int counter = 0;

        for (int i = 1; i <= 100; i++) {

            System.out.print(i + " ");
            counter++;

            if (counter == 10) {
                System.out.println("");
                counter = 0;
                //break;
            }
        }

        System.out.println("\n---------------------------------------\n");

        for (int i = 1; i <= 100; i++) {

            if (i % 2 == 0) {
                System.out.print(i + " ");
                counter++;
                if (counter == 10) {
                    System.out.println("");
                    counter = 0;
                    //break;
                }
            }
        }
    }

}
