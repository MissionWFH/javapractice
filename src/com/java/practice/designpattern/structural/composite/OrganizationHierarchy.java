package com.java.practice.designpattern.structural.composite;

public class OrganizationHierarchy {

    public static void main(String[] args) {
        // Creating the organization hierarchy
        Department organization = new Department("Microsoft");
        Department boardOfDirector = new Department("CEO");
        Employee ceo = new Manager("Satya Nadella");
        boardOfDirector.add(ceo);

        Department devDepartment = new Department("Development");
        Employee dev1 = new Developer("John Doe");
        Employee dev2 = new Developer("Jane Smith");
        devDepartment.add(dev1);
        devDepartment.add(dev2);

        Department hrDepartment = new Department("Human Resources");
        Employee hrManager = new Manager("Emily Brown");
        hrDepartment.add(hrManager);

        organization.add(boardOfDirector);
        organization.add(devDepartment);
        organization.add(hrDepartment);

        // Printing the hierarchy
        organization.print();
    }
}