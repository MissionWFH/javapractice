package com.java.practice.basics;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo {

    public DateDemo() {}

    public static void main(String[] args) {

        String s = new SimpleDateFormat("E, dd MMM yyyy hh:mm:ss a").format(new Date());
        String s1 = new SimpleDateFormat("dd MMM yy hh:mm:ss").format(new Date());
        String s2 = new SimpleDateFormat("h:mm a").format(new Date());
        String s3 = new SimpleDateFormat("HH:mm a").format(new Date());

        System.out.println(s + "\n" + s1 + "\n" + s2 + "\n" + s3);
    }
}
