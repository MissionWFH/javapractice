package com.java.practice.basics;

public class SumOfNumber {

    public static void main(String[] args) {

        int sum = 0;
        int i = 12345;
        while (i > 0) {
            int num = i % 10;
            // sum = ( sum * 10 ) + num;
            sum = sum + num;
            i = i / 10;
        }
        System.out.println(sum);
    }
}
