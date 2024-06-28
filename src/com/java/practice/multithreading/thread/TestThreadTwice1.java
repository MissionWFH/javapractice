package com.java.practice.multithreading.thread;

public class TestThreadTwice1 extends Thread {

    public void run() {
        System.out.println("running...");
        Runtime.getRuntime();
    }

    public static void main(String args[]) {
        System.out.println(Thread.currentThread().getName() + " -Thread");
        TestThreadTwice1 t1 = new TestThreadTwice1();

        // t1.start();
        t1.start();
    }
}  