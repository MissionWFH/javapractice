package com.java.practice.designpattern.behavioral.chainofresponsibility;

public interface Approver {

    void setNextApprover(Approver nextApprover);

    void processExpense(Expense expense);
}