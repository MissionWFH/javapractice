package com.java.practice.collections;

import java.util.List;

public class Employee {

    private int id;
    private String name;
    private int age;
    private long salary;
    private String gender;
    private String deptName;
    private String city;
    private int yearOfJoining;

    public Employee(int id, String name, int age, long salary, String gender,
                    String deptName, String city, int yearOfJoining) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.gender = gender;
        this.deptName = deptName;
        this.city = city;
        this.yearOfJoining = yearOfJoining;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getYearOfJoining() {
        return yearOfJoining;
    }

    public void setYearOfJoining(int yearOfJoining) {
        this.yearOfJoining = yearOfJoining;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", gender='" + gender + '\'' +
                ", deptName='" + deptName + '\'' +
                ", city='" + city + '\'' +
                ", yearOfJoining='" + yearOfJoining + '\'' +
                '}';
    }

    public static List<Employee> fetchEmployeeData() {
        return List.of(
                new Employee(1, "Yanksha", 28, 123, "F", "HR", "Blore", 2020),
                new Employee(2, "Francesca", 29, 120, "F", "HR", "Hyderabad", 2015),
                new Employee(3, "Ramesh", 30, 115, "M", "HR", "Chennai", 2014),
                new Employee(4, "Melanie", 32, 125, "F", "HR", "Chennai", 2013),
                new Employee(5, "Padma", 22, 150, "F", "IT", "Noida", 2013),
                new Employee(6, "Milad", 27, 140, "M", "IT", "Gurugram", 2017),
                new Employee(7, "Uzma", 26, 130, "F", "IT", "Pune", 2016),
                new Employee(8, "Ali", 23, 145, "M", "IT", "Trivandam", 2015),
                new Employee(9, "Ram", 25, 160, "M", "IT", "Blore", 2010),
                new Employee(10, "Alex", 23, 110, "M", "Admin", "Pune", 2013),
                new Employee(11, "Mona", 28, 120, "F", "Admin", "Hyderabad", 2015),
                new Employee(12, "John", 30, 140, "M", "Admin", "Hyderabad", 2017)
        );
    }
}