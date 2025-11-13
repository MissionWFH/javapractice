package com.java.practice.interviewqna;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class CollectionInterviewQnA {

    enum TxnType {DEPOSIT, WITHDRAWAL}

    static final class Customer {
        final int id;
        final String name;

        Customer(int id, String name) {
            this.id = id;
            this.name = name;
        }

        int id() {
            return id;
        }

        String name() {
            return name;
        }

        @Override
        public String toString() {
            return name + "(" + id + ")";
        }
    }

    static final class Transaction {
        final String id;
        final int customerId;
        final TxnType type;
        final String category;
        final double amount;
        final LocalDateTime when;

        Transaction(String id, int customerId, TxnType type, String category, double amount, LocalDateTime when) {
            this.id = id;
            this.customerId = customerId;
            this.type = type;
            this.category = category;
            this.amount = amount;
            this.when = when;
        }

        String id() {
            return id;
        }

        int customerId() {
            return customerId;
        }

        TxnType type() {
            return type;
        }

        String category() {
            return category;
        }

        double amount() {
            return amount;
        }

        LocalDateTime when() {
            return when;
        }
    }

    static final class CustomerNet {
        final Customer customer;
        final double netInflow;

        CustomerNet(Customer customer, double netInflow) {
            this.customer = customer;
            this.netInflow = netInflow;
        }

        Customer customer() {
            return customer;
        }

        double netInflow() {
            return netInflow;
        }

        @Override
        public String toString() {
            return customer.name() + ": net=" + String.format("%.2f", netInflow);
        }
    }

    /**
     * Que (Streams only, no loops):</br>
     * For each customer, compute net inflow = sum(deposits) - sum(withdrawals).
     * Return the top-N customers sorted by:
     * 1) net inflow DESC
     * 2) customer name ASC (tie-breaker)
     * <p>
     * Performance note: Avoid O(n^2). Prefer grouping transactions once.
     */
    static List<CustomerNet> topNByNetInflow(List<Customer> customers, List<Transaction> txns, int n) {
        Map<Integer, Double> txnByCustomer =
                txns.stream()
                        .collect(Collectors.groupingBy(Transaction::customerId,
                                Collectors.summingDouble(txn -> txn.type() == TxnType.DEPOSIT
                                        ? txn.amount() : -txn.amount())));
        System.out.println(txnByCustomer);

        return customers.stream()
                .filter(customer -> txnByCustomer.containsKey(customer.id()))
                .map(customer -> new CustomerNet(customer, txnByCustomer.get(customer.id())))
                .sorted(Comparator.comparingDouble(CustomerNet::netInflow).reversed()
                        .thenComparing(customerNet -> customerNet.customer().name()))
                .limit(n)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Customer> customers = sampleCustomers();
        List<Transaction> txns = sampleTransactions();

        List<CustomerNet> top3 = topNByNetInflow(customers, txns, 3);

        System.out.println("Top-3 by net inflow:");
        top3.forEach(cn -> System.out.printf("  %s: net=%.2f%n", cn.customer().name(), cn.netInflow()));

        /*
        ===== Expected Output =====

        Top-3 by net inflow:
          Alice: net=950.00
          Bob: net=200.00
          Chitra: net=150.00

        Explanation:
        Alice: deposits 1000 + 300 = 1300; withdrawals 200 + 150 = 350; net = 950
        Bob  : deposits 800; withdrawals 500 + 100 = 600; net = 200
        Chitra: deposits 200; withdrawals 50; net = 150
        Deepak: deposits 1000; withdrawals 400 + 500 = 900; net = 100
        Esha: no transactions => net = 0
        */
    }

    // ---------- Sample Data ----------
    static List<Customer> sampleCustomers() {
        return List.of(
                new Customer(1, "Alice"),
                new Customer(2, "Bob"),
                new Customer(3, "Chitra"),
                new Customer(4, "Deepak"),
                new Customer(5, "Esha")
        );
    }

    static List<Transaction> sampleTransactions() {
        return List.of(
                new Transaction("T1001", 1, TxnType.DEPOSIT, "SALARY", 1000, LocalDateTime.of(2025, 7, 30, 9, 0)),
                new Transaction("T1002", 1, TxnType.WITHDRAWAL, "GROCERY", 200, LocalDateTime.of(2025, 8, 1, 18, 20)),
                new Transaction("T1003", 1, TxnType.WITHDRAWAL, "FOOD", 150, LocalDateTime.of(2025, 8, 2, 12, 15)),
                new Transaction("T1004", 2, TxnType.DEPOSIT, "SALARY", 800, LocalDateTime.of(2025, 7, 29, 9, 0)),
                new Transaction("T1005", 2, TxnType.WITHDRAWAL, "RENT", 500, LocalDateTime.of(2025, 8, 1, 10, 0)),
                new Transaction("T1006", 2, TxnType.WITHDRAWAL, "UTILITIES", 100, LocalDateTime.of(2025, 8, 3, 11, 30)),
                new Transaction("T1007", 3, TxnType.WITHDRAWAL, "FOOD", 50, LocalDateTime.of(2025, 8, 1, 13, 0)),
                new Transaction("T1008", 3, TxnType.DEPOSIT, "REFUND", 200, LocalDateTime.of(2025, 8, 4, 9, 0)),
                new Transaction("T1009", 1, TxnType.DEPOSIT, "REFUND", 300, LocalDateTime.of(2025, 8, 5, 10, 45)),
                new Transaction("T1010", 4, TxnType.WITHDRAWAL, "TRAVEL", 400, LocalDateTime.of(2025, 8, 2, 20, 0)),
                new Transaction("T1011", 4, TxnType.DEPOSIT, "SALARY", 1000, LocalDateTime.of(2025, 7, 31, 9, 0)),
                new Transaction("T1012", 4, TxnType.WITHDRAWAL, "RENT", 500, LocalDateTime.of(2025, 8, 3, 9, 0))
        );
    }
}
