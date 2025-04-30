package com.java.practice.multithreading.thread;

public class ThreadRunTwiceDemo extends Thread {

    public void run() {
        System.out.println("running...");
        Runtime.getRuntime();
    }

    public static void main(String args[]) {
        System.out.println(Thread.currentThread().getName() + " -Thread");
        ThreadRunTwiceDemo t1 = new ThreadRunTwiceDemo();

        t1.start();
       // t1.start(); //RE: IllegalThreadStateException
    }
}  