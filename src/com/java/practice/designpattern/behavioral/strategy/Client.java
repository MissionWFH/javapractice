package com.java.practice.designpattern.behavioral.strategy;

public class Client {

    public static void main(String[] args) {

        ShoppingCart cart = new ShoppingCart();

        // Choose Credit Card payment strategy
        cart.setPaymentStrategy(new CreditCardPayment("1234-5678-9012-3456", "12/25", "123"));
        cart.pay(100); // Output: 100 paid with Credit Card

        // Choose UPI payment strategy
        cart.setPaymentStrategy(new UPIPayment("test.user@ybl"));
        cart.pay(50);  // Output: 50 paid with PhonePe
    }
}