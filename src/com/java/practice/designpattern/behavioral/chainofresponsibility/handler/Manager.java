package com.java.practice.designpattern.behavioral.chainofresponsibility.handler;

import com.java.practice.designpattern.behavioral.chainofresponsibility.Approver;
import com.java.practice.designpattern.behavioral.chainofresponsibility.Expense;

//Implement Concrete Handlers
public class Manager implements Approver {

    private Approver nextApprover;
    private static final double APPROVAL_LIMIT = 1000.0;

    @Override
    public void setNextApprover(Approver nextApprover) {
        this.nextApprover = nextApprover;
    }

    @Override
    public void processExpense(Expense expense) {
        if (expense.getAmount() <= APPROVAL_LIMIT) {
            System.out.println("Manager approved Expense #" + expense.getId() + " for $" + expense.getAmount());
        } else if (nextApprover != null) {
            System.out.println("Manager cannot approve. Passing to next approver");
            nextApprover.processExpense(expense);
        }
    }
}
