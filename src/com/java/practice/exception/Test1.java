package com.java.practice.exception;

public class Test1 {
    public static void throwit() throws Error {
        throw new Error();
    }

    public static void main(String args[]) {
        try {
            System.out.println("Hello world ");
            throwit();
            System.out.println("Done with try block ");
        } catch (Error e) {
            System.out.println("Error Handled ");
        } catch (Exception e) {
            System.out.println("Exception Handled ");
        } finally {
            System.out.println("Finally executing ");
        }
    }
}
