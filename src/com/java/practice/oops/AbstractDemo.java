package com.java.practice.oops;

abstract class A {
    abstract void m1(String s);
}

interface B {
    void m1(String s);

}

interface C {
     void m1(String s);

}

class D {
    void m2(String s) {
        System.out.println(s);
    }
}

public class AbstractDemo extends A implements B, C {

    public void m1(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) {
        A a = new AbstractDemo();
        a.m1("A");

        B b = new AbstractDemo();
        b.m1("B");

        C c = new AbstractDemo();
        c.m1("C");

        D d = new D();
        d.m2("D");

        AbstractDemo ad = new AbstractDemo();
        ad.m1("AbstractDemo");
    }
}
