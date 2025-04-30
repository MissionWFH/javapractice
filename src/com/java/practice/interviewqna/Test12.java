package com.java.practice.interviewqna;

import java.util.concurrent.ConcurrentHashMap;

public class Test12 {
    public static void main(String[] args) {
        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
        map.put(2, 20);
        map.put(3, 30);
        map.put(4, 40);

        Integer output = map.entrySet()
                .stream()
                .mapToInt(x -> x.getKey() * x.getValue())
                .sum();

        // 2*20 + 3*30 + 4*40
        System.out.println(output); // Output: 290
    }
}