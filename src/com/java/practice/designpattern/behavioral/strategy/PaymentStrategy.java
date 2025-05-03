package com.java.practice.designpattern.behavioral.strategy;

// strategy
interface PaymentStrategy {

    void pay(int amount);
}

// concrete strategy
class CreditCardPayment implements PaymentStrategy {

    private final String cardNumber;
    private final String expiryDate;
    private final String cvv;

    public CreditCardPayment(String cardNumber, String expiryDate, String cvv) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid with Credit Card");
    }
}

// concrete strategy
class UPIPayment implements PaymentStrategy {

    private String upiID;

    public UPIPayment(String upiID) {
        this.upiID = upiID;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid with UPI");
    }
}