package com.java.practice.designpattern.structural.proxy;

public class Client {

    public static void main(String[] args) {
        Image image = new ProxyImage("photo.jpg");
        image.display(); // Loads and displays
        image.display(); // Just displays
    }
}