package com.java.practice.designpattern.pubsub;

import java.util.ArrayList;
import java.util.List;

public class Topic {

    private String name;
    private List<Subscriber> subscribers = new ArrayList<>();;

    public Topic(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void notifySubscribers(String message) {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(name, message);
        }
    }
}