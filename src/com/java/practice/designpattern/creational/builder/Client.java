package com.java.practice.designpattern.creational.builder;

public class Client {

    public static void main(String[] args) {
        Computer computer1 = Computer.builder()
                .setProcessor("Intel i7")
                .setRam(16)
                .setStorage(512)
                .setGraphicsCard("Nvidia RTX 3080")
                .build();

        Computer computer2 = Computer.builder()
                .setProcessor("Apple M4 chip")
                .setRam(8)
                .setStorage(256)
                .build();

        System.out.println(computer1);
        System.out.println(computer2);
    }
}