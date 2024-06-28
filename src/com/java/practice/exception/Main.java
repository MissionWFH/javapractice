package com.java.practice.exception;

class A {
    public int m1(int a) {
        try {
            System.out.println("insisde m1");
            return 100;
        } catch (Exception e) {
            System.out.println(e);
            return 200;
        } finally {
            System.out.println("print");
            //  return 300;
        }
    }

   /* public int m1(int a) {
        System.out.println("insisde m1");
        return 100;
    }*/

    public void m1(int a, String str) {
        System.out.println("insisde m1 with String A");
    }
}

class B extends A {
    public void m1(int a, String str) {
        System.out.println("insisde m1 with String B");
    }
}

class Main {
    public static void main(String[] args) {
        A aa = new B();
        aa.m1(1, "abc");

        A a = null;
        //a == null; //true
        //a.equals(null); //NE

        A a1 = new A();
        a1.m1(2, "qwe");
        System.out.println(a1.m1(55));
    }
}