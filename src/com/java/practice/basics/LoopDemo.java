package com.java.practice.basics;


public class LoopDemo {

    public LoopDemo() {
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                continue;
                //break;
            }
            System.out.println(i);
        }
    }

}

