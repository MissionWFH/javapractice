package com.java.practice.basics;

import java.net.URL;
import java.net.URLConnection;

public class CheckInternetConnection {

    public static void main(String[] args) {

        try {
            URL url = new URL("http://www.google.com");

            URLConnection connection = url.openConnection();
            connection.connect();

            System.out.println("Internet Connected");

        } catch (Exception e) {

            System.out.println("Sorry, No Internet Connection");

        }

    }
}
