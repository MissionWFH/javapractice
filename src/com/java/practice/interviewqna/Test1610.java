package com.java.practice.interviewqna;

import java.util.ArrayList;
import java.util.List;

class Parent {
    public void run() {
        walk();
        System.out.println("Parent run");
    }

    public void walk() {
        System.out.println("Parent walk");
    }
}

class Child extends Parent {

    public void run() {
        super.run();
        System.out.println("child run");
    }

    public void walk() {
        super.walk();
        System.out.println("child walk");
    }
}

public class Test1610 {

    public static void main(String[] args) {

        Parent p = new Child();
        p.run(); // parent walk parent run child run

        System.out.println("-----------------------");
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        for (Integer i : list) {
            //System.out.println(i);
            //list.add(3); // ConcurrentModificationException
        }

        System.out.println("-----------------------");
        List<String> a = new ArrayList<>();
        a.add("ABC");
        a.add("BCD");
        a.add("KGF");
        method2(a);
        System.out.println("a: " + a); // ABC BCD KGF KLP
    }

    static void method2(List<String> b) {
        b.add("KLP");
        System.out.println("b: " + b);// ABC BCD KGF KLP
    }
}