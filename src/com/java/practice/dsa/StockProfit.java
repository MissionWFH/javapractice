package com.java.practice.dsa;

import java.util.Arrays;

public class StockProfit {

    public static void main(String[] args) {
        int[] stockPrices = {7, 1, 5, 3, 6, 4};
        System.out.println("Maximum profit for given stock price: " + Arrays.toString(stockPrices));
        System.out.println(maxProfit(stockPrices));
    }

    public static int maxProfit(int[] stockPrices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : stockPrices) {
            if (price < minPrice) {
                minPrice = price; // update minimum so far
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice; // calculate max profit
            }
        }
        return maxProfit;
    }
}
