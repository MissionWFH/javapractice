package com.java.practice.collections;

import java.util.List;

public record Employee(int id,
                       String name,
                       int age,
                       long salary,
                       String gender,
                       String deptName,
                       String city,
                       int yearOfJoining) {

    public static List<Employee> fetchEmployeeData() {
        return List.of(
                new Employee(1, "Yanksha", 28, 123, "F", "HR", "Blore", 2020),
                new Employee(2, "Francesca", 29, 120, "F", "HR", "Hyderabad", 2015),
                new Employee(3, "Ramesh", 30, 115, "M", "HR", "Chennai", 2014),
                new Employee(4, "Melanie", 32, 145, "F", "HR", "Chennai", 2013),
                new Employee(5, "Padma", 32, 150, "F", "IT", "Noida", 2013),
                new Employee(6, "Milad", 32, 140, "M", "IT", "Gurugram", 2017),
                new Employee(7, "Uzma", 29, 130, "F", "IT", "Pune", 2016),
                new Employee(8, "Ali", 32, 145, "M", "IT", "Trivandam", 2015),
                new Employee(9, "Ram", 35, 160, "M", "IT", "Blore", 2010),
                new Employee(10, "Alex", 33, 110, "M", "Admin", "Pune", 2013),
                new Employee(11, "Mona", 29, 120, "F", "Admin", "Hyderabad", 2015),
                new Employee(12, "John", 30, 140, "M", "Admin", "Hyderabad", 2017)
        );
    }
}