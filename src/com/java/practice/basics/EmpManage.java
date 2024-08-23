package com.java.practice.basics;

import java.util.Scanner;

public class EmpManage {

    public static void main(String args[]) {

        try {
            int empId;
            String empName, post;
            double empSal;

            EmpDetails emp = new EmpDetails();

            Scanner sc = new Scanner(System.in);
            System.out.println("--------- Enter Emp Details ----------");

            System.out.print("Emp ID :");
            empId = sc.nextInt();

            System.out.print("Emp Name :");
            empName = sc.next();
            empName += sc.nextLine();

            System.out.print("Emp Post :");
            post = sc.next();
            post += sc.nextLine();

            System.out.print("Emp Salary :");
            empSal = sc.nextDouble();

            //sc.close();

            emp.setEmpId(empId);
            emp.setEmpName(empName);
            emp.setPost(post);
            emp.setEmpSal(empSal);

            emp.display();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}