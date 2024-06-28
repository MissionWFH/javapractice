package com.java.practice.basics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SearchElement {

    static StringBuffer sb;

    static int[] getRandomNums() {

        List<Integer> list = new ArrayList<>();
        Random r = new Random();

        for (int j = 0; j < 10; j++) {
            sb = new StringBuffer();
            for (int i = 0; i < 2; i++) {
                sb.append(r.nextInt(9) + 1);
            }
            list.add(Integer.parseInt(sb.toString()));
        }
        return list.stream().mapToInt(i -> i).toArray();

    }

    public static void main(String[] args) {
        int search = 0;
        Scanner sc = new Scanner(System.in);
        while (true) {
            int[] a = getRandomNums();
            int flag = 0;

            for (int i : a) {
                System.out.print(i + " ");
            }

            System.out.println("\nEnter num to be search.........");
            search = sc.nextInt();

            for (int i = 0; i < a.length; i++) {
                if (search == a[i]) {
                    System.out.println("found at " + (i + 1) + " Position\n");
                    flag = 1;
                    // break;
                }
            }
            if (flag == 0) {
                System.out.println("not found.\n");
            }
        }
    }
}
