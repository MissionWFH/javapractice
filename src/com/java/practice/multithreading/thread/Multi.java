package com.java.practice.multithreading.thread;

class Multi extends Thread {
    @Override
    public void run() {
        System.out.println("thread is running...");
    }

    public static void main(String args[]) {
        Multi t1 = new Multi();
        t1.start();
    }
}  