package com.java.practice.multithreading.thread;

class DeadLock extends Thread {
    public void run() {
        int x = 0, y = 0;
        for (int i = 0; i < 1000; i++)
            synchronized (DeadLock.class) {
                x = 12;
                y = 15;
            }
        System.out.print("x = " + x + " y = " + y + "\n");
    }
}

public class DeadlockDemo {

    public static void main(String[] args) {
        DeadLock lock1 = new DeadLock();
        DeadLock lock2 = new DeadLock();
        lock1.start();
        lock2.start();
    }
}