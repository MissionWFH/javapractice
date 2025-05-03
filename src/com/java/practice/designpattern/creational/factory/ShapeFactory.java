package com.java.practice.designpattern.creational.factory;

public class ShapeFactory {

    // factory method
    public Shape getShape(String shapeType) {
        if (shapeType == null)
            throw new IllegalStateException("shape type must not be null");

        return switch (shapeType.toUpperCase()) {
            case "CIRCLE" -> new Circle();
            case "SQUARE" -> new Square();
            default -> throw new IllegalStateException("Unknown shape type -> " + shapeType);
        };
    }
}