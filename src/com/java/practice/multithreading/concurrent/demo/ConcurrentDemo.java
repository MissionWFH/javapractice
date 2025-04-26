package com.java.practice.multithreading.concurrent.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Customer {

    private int balance = 6000;

    Customer() {
        System.out.println("-----------------------------");
        System.out.println("Account Balance : " + balance);
        System.out.println("-----------------------------");
    }

    synchronized void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + ": Going to withdraw " + amount + " amount");
        if (this.balance < amount) {
            System.out.println("Insufficient balance to withdraw. waiting for sometime...");
            System.out.println("Current balance: " + this.balance + "\n");
            try {
                wait(); // waiting thread...
            } catch (InterruptedException ie) {
                System.out.println(ie);
            }
        }

        this.balance -= amount;
        if (this.balance < 0) {
            System.out.println(Thread.currentThread().getName() + ": Again try to withdraw " + amount + " amount");
            this.balance += amount;
            System.out.println("Available Balance : " + this.balance + "\n");
            throw new ArithmeticException("Insufficient balance to withdraw.");
        }

        System.out.println(Thread.currentThread().getName() + ": Withdraw completed.");
        System.out.println("-----------------------------");
        System.out.println("New Account Bal : " + this.balance);
        System.out.println("-----------------------------");
    }

    synchronized void deposit(int amount) {
        System.out.println(Thread.currentThread().getName() + ": Going to deposit " + amount + " amount");
        this.balance += amount;
        System.out.println("Deposit completed.");
        System.out.println("New Account Bal : " + this.balance);
        System.out.println("-----------------------------");
        notify();
    }
}

class ConcurrentDemo {

    public static void main(String args[]) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(() -> {
            final Customer c = new Customer();
            new Thread(() -> c.withdraw(5200)).start();
            new Thread(() -> c.withdraw(1000)).start();
            new Thread(() -> c.deposit(2000)).start();
            new Thread(() -> c.withdraw(4000)).start();
            new Thread(() -> c.deposit(1000)).start();
            new Thread(() -> c.deposit(1000)).start();
        });
        executor.shutdown();
    }
}