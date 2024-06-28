package com.java.practice.oops;

class A1 {
    int a = 10;

    void m1() {
        System.out.println("A m1");
    }
}

class B1 extends A1 {
    int a = 11;

    @Override
    void m1() {
        System.out.println("B m1");
    }

    void m2() {
        System.out.println("B m2");
    }
}

public class C1 {
    public static void main(String[] args) {
        A1 object = new B1();
        System.out.println(object.a); // 10
        object.m1();
        // object.m2();
    }
}