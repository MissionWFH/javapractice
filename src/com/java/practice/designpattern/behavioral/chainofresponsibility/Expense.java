package com.java.practice.designpattern.behavioral.chainofresponsibility;

public class Expense {

    private final String description;
    private final double amount;
    private final int id;

    public Expense(int id, double amount, String description) {
        this.id = id;
        this.amount = amount;
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }
}
