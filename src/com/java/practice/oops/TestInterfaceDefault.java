package com.java.practice.oops;

interface Drawable {
    void draw();

    default void msg() {
        System.out.println("default interface method");
    }
}

class Rectangle implements Drawable {
    public void msg() {
        System.out.println("default Reactangle method");
    }

    public void draw() {
        System.out.println("drawing rectangle");
    }
}

public class TestInterfaceDefault {
    public static void main(String args[]) {
        Drawable d = new Rectangle();
        d.draw();
        d.msg();
    }
}