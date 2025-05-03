package com.java.practice.designpattern.creational.singleton;

public class Client {

    public static void main(String[] args) {

        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        System.out.println(s1 == s2); // true
        s1.showMessage();
    }
}
