package com.java.practice.exception;

import java.util.Scanner;

class IllegalSyntax extends RuntimeException {

    private static final long serialVersionUID = 5651748423694977200L;
    public IllegalSyntax(String msg) {
        super(msg);
    }
}

public class EmailValidation {

    public static void main(String[] args) {

        Thread.currentThread().setName("Email Validation");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter email address");
        String email = sc.next();
        if (email.contains("@")) {
            String domain = email.substring(email.lastIndexOf(".") + 1);
            if (domain.length() == 1 || domain.length() > 3)
                throw new IllegalSyntax("Invalid email format: " + email);
            System.out.println("Entered email address is valid ");
        } else {
            throw new IllegalSyntax("Invalid email: " + email);
        }
    }
}