package com.java.practice.multithreading;

import java.util.concurrent.*;

public class CyclicBarrierDemo {

    private static final int PARTIES = 3;
    private static final CyclicBarrier barrier = new CyclicBarrier(PARTIES);

    static class Worker extends Thread {
        public void run() {
            try {
                System.out.println(getName() + " reached the barrier");
                barrier.await(); // wait until all reach
                System.out.println(getName() + " passed the barrier");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i <= PARTIES; i++) {
            new Worker().start();
        }
    }
}
