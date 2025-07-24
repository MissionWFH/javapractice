package com.java.practice.interviewqna.oracle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OracalDemo {
    public static void main(String[] args) {

        HashMap<Integer, String> map = new HashMap<>();
        List<String> list1 = map.entrySet().stream()
                .filter(x -> x.getValue().length() > 10)
                .map(Map.Entry::getValue)
                .toList();

        oracleDemo oracleDemo = (a, b) -> a + b;
    }
}

@FunctionalInterface
interface oracleDemo {

    int sum(int a, int b);

}

