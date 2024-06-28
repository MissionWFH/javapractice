package com.java.practice.collections;

public class Student implements Comparable<Student> {

    private String name;
    private String school;
    private int age;

    public Student() {
        super();
    }

    public Student(String name, String school, int age) {
        this.name = name;
        this.school = school;
        this.age = age;
    }

    @Override
    public int compareTo(Student stud) {
        if (this.age > stud.getAge())
            return 1;
        else if (this.age < stud.getAge())
            return -1;
        else
            return 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", school=" + school + ", age=" + age + "]";
    }
}