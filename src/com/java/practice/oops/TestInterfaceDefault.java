package com.java.practice.oops;

@FunctionalInterface
interface Drawable {

    void draw();

    default void msg() {
        getData();
        System.out.println("default interface method");
    }

    private void getData() {
        System.out.println("private method in interface");
    }

    private static void getPrintData() {
        System.out.println("private static method in interface");
    }

    static void print() {
        getPrintData();
        System.out.println("static method in interface");
    }
}

class Rectangle implements Drawable {

    public void draw() {
        Drawable.super.msg();
        System.out.println("drawing rectangle");
    }

    public void msg() {
        System.out.println("Overridden implementation");
    }
}

public class TestInterfaceDefault {
    public static void main(String[] args) {
        Drawable d = new Rectangle();
        d.draw();
        d.msg();
        Drawable.print();
    }
}