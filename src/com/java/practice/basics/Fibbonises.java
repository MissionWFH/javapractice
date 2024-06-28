package com.java.practice.basics;

import java.util.ArrayList;
import java.util.List;

public class Fibbonises {
    public static void main(String[] args) {

        int no1 = 0, no2 = 1, no3 = 0, sum = 0;

        System.out.print("Fiboniese series :" + no1 + " " + no2);

        List<Integer> list = new ArrayList<>();

        for (int i = 2; i <= 10; i++) {
            no3 = no1 + no2;
            no1 = no2;
            no2 = no3;
            System.out.print(" " + no3);
            list.add(no3);
        }

        for (int i : list) {
            if (i % 2 == 0) {
                sum = sum + i;
            }
        }

        System.out.println("\nSum of even numbers in fibonises series :" + sum);
    }

}
