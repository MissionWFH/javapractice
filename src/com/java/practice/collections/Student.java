package com.java.practice.collections;

import java.util.Arrays;
import java.util.List;

public record Student(String name,
                      String school,
                      int age) implements Comparable<Student> {

    @Override
    public int compareTo(Student stud) {
        return this.age - stud.age();
    }

    public static List<Student> fetchStudentData() {
        return Arrays.asList(
                new Student("Ravi", "Modern", 12),
                new Student("Sai", "DVS", 30),
                new Student("Om", "Modern", 10),
                new Student("Prashant", "Modern", 28),
                new Student("Avi", "Modern", 30),
                new Student("Sai", "DVS", 32),
                new Student("Kishor", "DVS", 34),
                new Student("Kishor", "DVS", 34));
    }
}