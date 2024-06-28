package com.java.practice.basics;

//creating custom exception and use it

class IllegalSyntax extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 5651748423694977200L;

    public IllegalSyntax(String s) {
        super(s);
    }

}

public class TestSplit {

    public static void main(String[] args) {
        Thread.currentThread().setName("TestSplit");

        String test = "abc.def.1231";

        if (test.contains(".")) {
            String[] output = test.split("\\.");
            if (output.length != 3) {
                throw new IllegalSyntax(test + " - invalid input argument.");
            } else {
                System.out.println(output[0]);
                System.out.println(output[1]);
                System.out.println(output[2]);
            }
        } else {
            throw new IllegalSyntax(test + " - invalid format.");
        }

    }

}