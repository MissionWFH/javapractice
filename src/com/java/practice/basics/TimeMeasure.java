package com.java.practice.basics;

public class TimeMeasure {

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
        //long timeSeconds = TimeUnit.MILLISECONDS.toSeconds(startTime);

        System.out.println("before for loop: " + (System.currentTimeMillis() - startTime) / 1000);
        long total = 0;
        for (int i = 0; i < 8; i++) {
            Test1.getTemp();
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            total += i;
        }
        System.out.println(total);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //long stopTime = System.currentTimeMillis();

        System.out.println("after for loop: " + (System.currentTimeMillis() - startTime) / 1000 + "ms");

        //long stopTime = System.currentTimeMillis();
		      /*long elapsedTime = stopTime - startTime;
		      System.out.println((System.currentTimeMillis() -startTime)/1000);*/
    }
}