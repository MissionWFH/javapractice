package com.java.practice.designpattern.structural.composite;

import java.util.ArrayList;
import java.util.List;

// Component Interface
interface Employee {

    void print();
}

// Leaf Node
class Developer implements Employee {

    private String name;

    public Developer(String name) {
        this.name = name;
    }

    @Override
    public void print() {
        System.out.println("Developer -> " + name);
    }
}

// Leaf Node
class Manager implements Employee {

    private String name;

    public Manager(String name) {
        this.name = name;
    }

    @Override
    public void print() {
        System.out.println("Manager -> " + name);
    }
}

// Composite Node
class Department implements Employee {

    private String name;
    private List<Employee> employees = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    public void add(Employee employee) {
        employees.add(employee);
    }

    public void remove(Employee employee) {
        employees.remove(employee);
    }

    @Override
    public void print() {
        System.out.println("Department -> " + name);
        for (Employee employee : employees) {
            employee.print();
        }
    }
}