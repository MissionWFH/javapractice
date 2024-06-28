package com.java.practice.basics;


class Wombat {
    static int frogCount = 0;            // Declare and initialize

    // static variable
    public Wombat() {
        frogCount += 1;        // Modify the value in the constructor
    }

    public static void main(String[] args) {
        new Wombat();
        new Wombat();
        new Wombat();
        System.out.println("Frog count is now " + frogCount);
    }
}