package com.java.practice.multithreading.thread;

public class EvenOddThreadDemo {

    private int number = 1;
    private final int MAX = 10;

    public static void main(String[] args) {
        EvenOddThreadDemo printer = new EvenOddThreadDemo();
        Thread oddThread = new Thread(printer::printOdd);
        Thread evenThread = new Thread(printer::printEven);

        oddThread.start();
        evenThread.start();
    }

    public synchronized void printOdd() {
        while (number <= MAX) {
            if (number % 2 == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Odd: " + number++);
            notify();
        }
    }

    public synchronized void printEven() {
        while (number <= MAX) {
            if (number % 2 != 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Even: " + number++);
            notify();
        }
    }
}