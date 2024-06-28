package com.java.practice.oops;

class Parent {
    void run1() {
        System.out.println("Parent running 1");
    }

    void run() {
        System.out.println("Parent running");
    }
}

public class Child extends Parent {
    void run() {
        System.out.println("Child running 60km");
    }

    void fast() {
        System.out.println("Child running fastly with 60km");
    }

    public static void main(String[] args) {
        Parent parent = new Child();
        parent.run();
        parent.run1();
        //parent.fast();

        Child child = new Child();
        child.run1();
        child.fast();
    }
}