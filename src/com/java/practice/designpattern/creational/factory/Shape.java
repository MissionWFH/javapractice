package com.java.practice.designpattern.creational.factory;

// Product Interface
interface Shape {

    void draw();
}

// Concrete Products
class Circle implements Shape {

    public void draw() {
        System.out.println("Drawing Circle");
    }
}

class Square implements Shape {

    public void draw() {
        System.out.println("Drawing Square");
    }
}