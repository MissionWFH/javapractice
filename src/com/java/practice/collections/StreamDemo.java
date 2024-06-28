package com.java.practice.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StreamDemo {

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Ravi", "Modern", 12));
        studentList.add(new Student("Sai", "DVS", 30));
        studentList.add(new Student("Om", "Modern", 10));
        studentList.add(new Student("Avi", "DVS", 28));
        studentList.add(new Student("Sai", "ZP", 16));
        studentList.add(new Student("Kishor", "DVS", 34));

        System.out.println("::::: Sort based on Age of students ::::: ");
        Collections.sort(studentList, new AgeComparator()); // sorting based on age of students
        studentList.stream().forEach(System.out::println);

        System.out.println("=================================================");
        System.out.println("::::: Sort based on Name of students ::::: ");
        Collections.sort(studentList, new NameComparator()); // sorting based on name of students
        studentList.stream().forEach(System.out::println);

        System.out.println("=================================================");
        System.out.println("::::: Filter the students that age is > 15 ::::: ");
        studentList.stream().sorted((s1, s2) -> s1.getAge() - s2.getAge()).filter(age -> age.getAge() > 15)
                .forEach(System.out::println);

        System.out.println("=================================================");
        System.out.println("::::: Get the min age of student ::::: ");
        // studentList.stream().min((s1, s2) -> s1.getAge() - s2.getAge()).stream().forEach(System.out::println);

        System.out.println("=================================================");
        System.out.println("::::: Get the max age of student ::::: ");
        //studentList.stream().max((s1, s2) -> s1.getAge() - s2.getAge()).stream().forEach(System.out::println);

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