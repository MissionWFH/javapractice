package com.java.practice.multithreading.runnable;

class RunnableDemo implements Runnable {
    public void run() {
        System.out.println("thread is running...");
    }

    public static void main(String args[]) {
        RunnableDemo m1 = new RunnableDemo();
        Thread t1 = new Thread(m1);
        t1.start();
    }
}  