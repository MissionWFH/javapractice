package com.java.practice.designpattern.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

interface Subject {

    void subscribe(Observer observer);

    void unSubscribe(Observer observer);

    void notifyObservers();
}

// Concrete Subject
class AppleStore implements Subject {

    private int price;
    private final List<Observer> observers = new ArrayList<>();

    public void setPrice(int price) {
        this.price = price;
        notifyObservers();
    }

    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unSubscribe(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this.price);
        }
    }
}