package com.java.practice.basics;

class Test3 {

    public static void main(String[] args) {

        float f = 10.5f;
        int a1 = (int) f;//Compile time error
        long a = (long) f;
        System.out.println(f);
        System.out.println(a1);

        int x =10;
        int b = x++;
        System.out.println(x);
    }
}