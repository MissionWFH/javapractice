package com.java.practice.basics;

public class Test1 {

    public static void main(String[] args) {

        getTemp();
    }

    public static void getTemp() {
        int[] temp = {56, 33, 70, 42, 55, 60, 59};

        String result = "";
        long startTime = System.currentTimeMillis();
        System.out.println("----- Milk Container value ----- ");

        for (int i : temp) {
            //System.out.println("In temp for loop: " +(System.currentTimeMillis() -startTime)/1000);
            result = (i >= 55) ? "RED" : (i >= 40 && i <= 55) ? "GREEN" : (i <= 40) ? "Yellow" : "";
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("Milk : " + i + " liters :" + " Alert : " + result + "\n");

        }

        //System.out.println("outside temp for loop: " +(System.currentTimeMillis() -startTime)/1000);

    }
}
