package com.java.practice.designpattern.behavioral.observer;

interface Observer {

    void update(int price);
}

// Concrete Observer
class Customer implements Observer {

    private String name;

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public void update(int price) {
        System.out.println(name + " iPhone available for " + price + " only at store ");
    }
}