package com.java.practice.designpattern.behavioral.chainofresponsibility.handler;

import com.java.practice.designpattern.behavioral.chainofresponsibility.Approver;
import com.java.practice.designpattern.behavioral.chainofresponsibility.Expense;

//Implement Concrete Handlers
public class Director implements Approver {

    private Approver nextApprover;
    private static final double APPROVAL_LIMIT = 10000.0;

    @Override
    public void setNextApprover(Approver nextApprover) {
        this.nextApprover = nextApprover;
    }

    @Override
    public void processExpense(Expense expense) {
        if (expense.getAmount() <= APPROVAL_LIMIT) {
            System.out.println("Director approved Expense #" + expense.getId() + " for $" + expense.getAmount());
        } else if (nextApprover != null) {
            System.out.println("Director cannot approve. Passing to next approver");
            nextApprover.processExpense(expense);
        }
    }
}
