package com.java.practice.basics;

import java.util.ArrayList;
import java.util.List;

public final class ImmutableClassDemo {
    private final long id;
    private final String name;
    private final List<String> tokens;

    public ImmutableClassDemo(long id, String name, List<String> tokens) {
        this.id = id;
        this.name = name;
        this.tokens = tokens;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getTokens() {
        return new ArrayList<>(tokens);
    }

    @Override
    public String toString() {
        return "ImmutableClassDemo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tokens=" + tokens +
                '}';
    }

    public static void main(String[] args) {
        ArrayList<String> tokens = new ArrayList<>();
        tokens.add("active");

        ImmutableClassDemo immutableClass = new ImmutableClassDemo(1, "value", tokens);
        System.out.println(immutableClass);   //ImmutableClassDemo{id=1, name='value', tokens=[active]}

        immutableClass.getTokens().add("new token");
        System.out.println(immutableClass);   //ImmutableClassDemo{id=1, name='value', tokens=[active]}
    }
}
