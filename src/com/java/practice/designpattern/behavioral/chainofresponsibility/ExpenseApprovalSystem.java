package com.java.practice.designpattern.behavioral.chainofresponsibility;

import com.java.practice.designpattern.behavioral.chainofresponsibility.handler.CEO;
import com.java.practice.designpattern.behavioral.chainofresponsibility.handler.Director;
import com.java.practice.designpattern.behavioral.chainofresponsibility.handler.Manager;

// Client Class
public class ExpenseApprovalSystem {
    public static void main(String[] args) {

        Approver manager = new Manager();
        Approver director = new Director();
        Approver ceo = new CEO();

        manager.setNextApprover(director);
        director.setNextApprover(ceo);

        Expense expense1 = new Expense(1, 500.00, "Team Lunch");
        Expense expense2 = new Expense(2, 5500.00, "Conference Travel");
        Expense expense3 = new Expense(3, 25000.00, "New Equipment Purchase");

        System.out.println("--- Processing Expense 1 ---");
        manager.processExpense(expense1);

        System.out.println("\n--- Processing Expense 2 ---");
        manager.processExpense(expense2);

        System.out.println("\n--- Processing Expense 3 ---");
        manager.processExpense(expense3);
    }
}
