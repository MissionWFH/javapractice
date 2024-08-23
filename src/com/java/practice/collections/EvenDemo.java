package com.java.practice.collections;

import java.util.*;

public class EvenDemo {

    public static void main(String[] args) {
        even(5, 15);
    }

    public static void even(int i, int j) {

        List<Integer> list = new ArrayList<>();
        int k;
        for (k = i; k <= j; k++) {
            list.add(k);
            System.out.print(k + " ");
        }

        System.out.println("\n");

        for (int m : list) {
            if (m % 2 == 0) {
                System.out.print(m + " ");
            }
        }
        list.stream().mapToInt(num -> num).filter(even -> even % 2 == 0).forEach(data -> System.out.print(data + " "));
    }
}