package com.java.practice.basics;

import java.util.Arrays;

public class Test1 {

    public static void main(String[] args) {
        getTemp();
    }

    public static void getTemp() {

        int[] temp = SearchElement.getRandomNums();
        String result;
        long startTime = System.currentTimeMillis();

        System.out.println("----- Milk Temperature in container ----- " + Arrays.deepToString(Arrays.stream(temp).boxed().toArray()));

        for (int i : temp) {
            //System.out.println("In temp for loop: " +(System.currentTimeMillis() -startTime)/1000);
            result = i >= 55 ? "RED" : i >= 40 ? "GREEN" : "Yellow";
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("Milk Temp: " + i + " celsius " + " Alert: " + result + "\n");
        }
        //System.out.println("outside temp for loop: " +(System.currentTimeMillis() -startTime)/1000);
    }
}
