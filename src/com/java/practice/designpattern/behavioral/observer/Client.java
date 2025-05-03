package com.java.practice.designpattern.behavioral.observer;

public class Client {

    public static void main(String[] args) {

        AppleStore subject = new AppleStore();

        Customer observer1 = new Customer("Kishor");
        Customer observer2 = new Customer("Sainath");
        Customer observer3 = new Customer("Avinash");

        subject.subscribe(observer1);
        subject.subscribe(observer2);
        subject.subscribe(observer3);
        subject.setPrice(60000);

        subject.unSubscribe(observer3);
        System.out.println("Get notify for remaining subscriber...");
        subject.setPrice(50000);
    }
}
