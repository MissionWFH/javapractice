package com.java.practice.multithreading.thread;

class Task {
    public synchronized void method1(Task t2) {
        System.out.println(Thread.currentThread().getName() + " is executing method1");
        t2.method2();
    }

    public synchronized void method2() {
        System.out.println(Thread.currentThread().getName() + " is executing method2");
    }
}

public class DeadlockDemo {

    public static void main(String[] args) {
        Task t1 = new Task();
        Task t2 = new Task();

        Thread th1 = new Thread(() -> t1.method1(t2));
        Thread th2 = new Thread(() -> t2.method1(t1));

        th1.start();
        th2.start();
    }
}