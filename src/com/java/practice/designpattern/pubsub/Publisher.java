package com.java.practice.designpattern.pubsub;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Publisher {

    private Map<String, Topic> topics = new HashMap<>();

    public void createTopic(String topicName) {
        topics.putIfAbsent(topicName, new Topic(topicName));
    }

    public void subscribe(String topicName, Subscriber subscriber) {
        Topic topic = topics.get(topicName);
        if (Objects.nonNull(topic)) {
            topic.addSubscriber(subscriber);
        } else {
            System.out.println("Topic '" + topicName + "' does not exist.");
        }
    }

    public void publish(String topicName, String message) {
        Topic topic = topics.get(topicName);
        if (Objects.nonNull(topic)) {
            topic.notifySubscribers(message);
        } else {
            System.out.println("Topic '" + topicName + "' does not exist. Message not published.");
        }
    }
}