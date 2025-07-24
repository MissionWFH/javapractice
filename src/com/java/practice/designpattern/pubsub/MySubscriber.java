package com.java.practice.designpattern.pubsub;

interface Subscriber {
    void update(String topic, String message);
}

public class MySubscriber implements Subscriber {

    private String name;

    public MySubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String topic, String message) {
        System.out.println(name + " received message from topic '" + topic + "': " + message);
    }

    public static void main(String[] args) {

        Publisher publisher = new Publisher();
        publisher.createTopic("news");
        publisher.createTopic("weather");

        MySubscriber subscriber1 = new MySubscriber("Subscriber A");
        MySubscriber subscriber2 = new MySubscriber("Subscriber B");

        publisher.subscribe("news", subscriber1);
        publisher.subscribe("weather", subscriber1);
        publisher.subscribe("news", subscriber2);

        publisher.publish("news", "Breaking News: Major event occurred!");
        publisher.publish("weather", "Today's forecast: Sunny with a chance of showers.");
        publisher.publish("sports", "No sports news today."); // Will show topic not found
    }
}