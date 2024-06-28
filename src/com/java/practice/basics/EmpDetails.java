package com.java.practice.basics;

public class EmpDetails {
    private int empId;
    private String empName, post;
    private double empSal;

    double PF;
    double netSal;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public double getEmpSal() {
        return empSal;
    }

    public void setEmpSal(double empSal) {
        this.empSal = empSal;
    }

    public void display() {
        System.out.println("--------------------------------------------------------------------");
        System.out.println("\nEmp_ID \tEmp_Name \tEmp_Post \t Emp_Gross_Salary");
        System.out.println(getEmpId() + "\t" + getEmpName() + "\t" + getPost() + "\t\t " + getEmpSal() + "\n");


        if (getEmpSal() >= 15000) {
            PF = (getEmpSal() / 100) * 12;
            netSal = getEmpSal() - PF;

            setEmpSal(netSal);
            netSalDisplay();

        }
    }

    public void netSalDisplay() {
        System.out.println("======================================================================");
        System.out.println("After deduction salary of emp : " + getEmpName() + "\n");
        System.out.println("Emp_ID \tEmp_Name \tEmp_Post \t Emp_Net_Salary \t Emp_deducted_PF");
        System.out.println(getEmpId() + "\t" + getEmpName() + "\t" + getPost() + "\t\t  " + getEmpSal() + "\t\t" + PF);
        System.out.println("======================================================================");

    }

}
