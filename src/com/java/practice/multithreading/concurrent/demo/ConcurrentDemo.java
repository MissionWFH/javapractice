package com.java.practice.multithreading.concurrent.demo;

class Customer {

    private int amount = 10000;

    Customer() {
        System.out.println("-----------------------------");
        System.out.println("Account Balance : " + amount);
        System.out.println("-----------------------------");
    }

    synchronized void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + ": going to withdraw " + amount + " amount ...");
        if (this.amount < amount) {
            System.out.println("Insufficient balance to withdraw. Current balance: " + this.amount + "\n");
            try {
                wait(); // waiting thread...
            } catch (InterruptedException ie) {
                System.out.println(ie);
            }
        }

        this.amount -= amount;

        System.out.println(Thread.currentThread().getName() + ": withdraw completed " + amount);
        System.out.println("-----------------------------");
        System.out.println("New Account Bal : " + this.amount);
        System.out.println("-----------------------------");
    }

    synchronized void deposit(int amount) {
        System.out.println(Thread.currentThread().getName() + ": going to deposit amount ... " + amount);
        this.amount += amount;
        System.out.println("deposit completed... " + amount);
        System.out.println("New Account Bal : " + this.amount);
        System.out.println("-----------------------------");
        notify();
    }
}

class ConcurrentDemo {

    public static void main(String args[]) {
        final Customer c = new Customer();
        new Thread(() -> c.withdraw(15000)).start();
        new Thread(() -> c.withdraw(10000)).start();
        new Thread(() -> c.deposit(10000)).start();
    }
}