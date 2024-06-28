package com.java.practice.exception;

class M {
    void method() {
        throw new Error("device error");
    }
}

public class Tests {

    public static void main(String[] args) {
        try {
            M m = new M();
            m.method();
        } catch (Exception e) {
            System.out.println("exception handled");
        }
        System.out.println("normal flow...");
    }
}