package com.java.practice.exception;

public class Test {

    public static void main(String[] args) {
        doGetMore();
    }

    private static void doGetMore() {
        try {
            System.out.println(doGet());
        } catch (Exception e) {
            System.out.println("in doGetMore() Exception catch");
        }
    }

    public static int doGet() {
        int a;
        try {
            System.out.println("in try");
            a = 3 / 3;
            String s = null;
            System.out.println(s.length());
            return 100;
        } catch (ArithmeticException ae) {
            System.out.println("in ArithmeticException catch");
            a = 3 - 4;
            return 200;
        } catch (NullPointerException ne) {
            System.out.println("in NullPointerException catch");
            a = 3 + 4;
            return 300;
        } /*catch (Exception e) {
            System.out.println("in catch");
            a = 3 + 4;
            return a;
        }*/ finally {
            System.out.println("in finally");
            a = 3 * 4;
            return 400;
        }
    }
}