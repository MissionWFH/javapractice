package com.java.practice.collections;

import java.util.*;

public class StreamDemo {

    public static void main(String[] args) {

        List<Student> studentList = Arrays.asList(
                new Student("Ravi", "Modern", 12),
                new Student("Sai", "DVS", 30),
                new Student("Om", "Modern", 10),
                new Student("Avi", "DVS", 28),
                new Student("Sai", "ZP", 16),
                new Student("Kishor", "DVS", 34));

        System.out.println("::::: Sort based on Age of students ::::: ");
        Collections.sort(studentList, new AgeComparator()); // sorting based on age of students
        studentList.stream().forEach(System.out::println);

        System.out.println("=================================================");
        System.out.println("::::: Sort based on Name of students ::::: ");
        Collections.sort(studentList, new NameComparator()); // sorting based on name of students
        studentList.stream().forEach(System.out::println);

        System.out.println("=================================================");
        System.out.println("::::: Filter the students that age is > 15 ::::: ");
        studentList.stream().sorted(Comparator.comparingInt(Student::getAge)).filter(age -> age.getAge() > 15)
                .forEach(System.out::println);

        System.out.println("=================================================");
        System.out.println("::::: Get the min age of student ::::: ");
        Student minAgeStudent = studentList.stream().min(Comparator.comparingInt(Student::getAge)).get();
        studentList.stream().filter(studList -> studList.getAge() == minAgeStudent.getAge()).forEach(System.out::println);

        System.out.println("=================================================");
        System.out.println("::::: Get the max age of student ::::: ");
        Student maxAgeStudent = studentList.stream().max(Comparator.comparingInt(Student::getAge)).get();
        studentList.stream().filter(studList -> studList.getAge() == maxAgeStudent.getAge()).forEach(System.out::println);

        System.out.println("=================================================");
        System.out.println("::::: Sort based on Age of students using Comparable ::::: ");
        Collections.sort(studentList); // sorting based on age of students
        studentList.stream().forEach(System.out::println);
    }
}

class AgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.getAge() - s2.getAge();
    }
}

class NameComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        if (s1.getName().equals(s2.getName()))
            return s2.getAge() - s1.getAge();

        return s1.getName().compareTo(s2.getName());
    }
}