package com.java.practice.basics;

import java.util.Random;

public class GenerateOTP {
    static StringBuffer sb;
    static Random r = new Random();

    static void getOTP() {
        sb = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            sb.append(r.nextInt(9) + 1);
        }
        System.out.println(sb);

    }

    public static void main(String[] args) {
        System.out.println("Generating Sample 50 OTP");
        int count = 01;
        for (int i = 1; i <= 50; i++) {
            System.out.print((count++) + ". ");
            getOTP();
        }
    }

}
