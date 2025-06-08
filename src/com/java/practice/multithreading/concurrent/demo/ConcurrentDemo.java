package com.java.practice.multithreading.concurrent.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Customer {

    private int balance = 6000;

    public Customer() {
        System.out.println("-----------------------------");
        System.out.println("Account Balance : " + balance);
        System.out.println("-----------------------------");
    }

    public synchronized void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + ": Going to withdraw " + amount + " amount");
        if (this.balance < amount) {
            System.out.println("Insufficient balance to withdraw. wait for salary credited, try again later...");
            System.out.println("Current balance: " + this.balance + "\n");
            try {
                wait(); // waiting thread...
            } catch (InterruptedException ie) {
                System.out.println(ie);
            }
        }

        this.balance -= amount;
        if (this.balance < 0) {
            System.out.println(Thread.currentThread().getName() + ": Again trying to withdraw " + amount + " amount");
            this.balance += amount;
            System.out.println("Available Balance : " + this.balance + "\n");
            throw new ArithmeticException("Insufficient balance to withdraw.");
        }

        System.out.println(Thread.currentThread().getName() + ": Withdraw completed.");
        System.out.println("-----------------------------");
        System.out.println("New Account Bal : " + this.balance);
        System.out.println("-----------------------------");
    }

    public synchronized void deposit(int amount) {
        System.out.println(Thread.currentThread().getName() + ": Going to deposit " + amount + " amount");
        this.balance += amount;
        System.out.println("Deposit completed.");
        System.out.println("New Account Bal : " + this.balance);
        System.out.println("-----------------------------");
        notify();
    }

    public synchronized void salaryCredited(int amount) {
        System.out.println(Thread.currentThread().getName() + ": salary credited with " + amount + " amount");
        this.balance += amount;
        System.out.println("New Account Bal : " + this.balance);
        System.out.println("-----------------------------");
        notify();
    }
}

public class ConcurrentDemo {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.execute(() -> {
            final Customer c = new Customer();
            new Thread(() -> c.withdraw(5200), "Kishor").start();
            new Thread(() -> c.withdraw(1000), "Sainath").start();
            new Thread(() -> c.salaryCredited(2000), "Salary Credited").start();
            new Thread(() -> c.withdraw(4000), "Avinash").start();
            new Thread(() -> c.deposit(1000), "Sainath").start();
            new Thread(() -> c.deposit(1000), "Kishor").start();
        });
        executor.shutdown();
    }
}