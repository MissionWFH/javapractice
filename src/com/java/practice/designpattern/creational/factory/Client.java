package com.java.practice.designpattern.creational.factory;

public class Client {

    public static void main(String[] args) {

        ShapeFactory factory = new ShapeFactory();
        Shape shape = factory.getShape("circle");
        shape.draw(); // Drawing Circle
    }
}
