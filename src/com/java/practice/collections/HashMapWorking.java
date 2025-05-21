package com.java.practice.collections;

import java.util.HashMap;
import java.util.Hashtable;

public class HashMapWorking {

    public static void main(String[] args) {
        HashMap<Test, String> map = new HashMap<>(); // {2=E, 3=B, 19=G, 5=A, 7=C, 23=F, 11=D, 15=H}
//        Hashtable map = new Hashtable();
        map.put(new Test(5), "A");
        map.put(new Test(3), "B");
        map.put(new Test(7), "C");
        map.put(new Test(11), "D");
        map.put(new Test(2), "E");
        map.put(new Test(5), "A");
        map.put(new Test(23), "F"); // 7
        map.put(new Test(19), "G"); //3
        map.put(new Test(15), "H");
        System.out.println("Custom hashcode element printed from " + map.getClass().getSimpleName() + "\n" + map);
    }
}

class Test {
    int i;

    public Test(int i) {
        this.i = i;
    }

    @Override
    public int hashCode() {
        return i;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Test other = (Test) obj;
        return this.i == other.i;
    }

    @Override
    public String toString() {
        return i + "";
    }
}
