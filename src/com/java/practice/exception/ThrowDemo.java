package com.java.practice.exception;

public class ThrowDemo extends Exception {

    private static final long serialVersionUID = 1L;

    static void m1() throws ThrowDemo {
        throw new ThrowDemo();
    }

    public static void main(String args[]) {
        try {
            m1();
        } catch (ThrowDemo e) {
            e.printStackTrace();
        }
    }
}