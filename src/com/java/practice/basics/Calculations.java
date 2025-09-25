package com.java.practice.basics;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.*;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class Calculations {

    private static final int INACTIVITY_TIMEOUT_SECONDS = 10;

    public void operations() throws InterruptedException {

        System.out.println("                  Calculator                  ");
        System.out.println("------------------------------------------");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Modulo");
        System.out.println("6. Square");
        System.out.println("7. Cubes");
        System.out.println("8. Trigonometry operations...");
        System.out.println("------------------------------------------");
        System.out.println("\nEnter your choice...");

        Scanner sc = new Scanner(System.in);
        int choice = readWithTimeout(sc::nextInt);
        System.out.println("------------------------------------------");

        switch (choice) {
            case 1 -> performBinaryOperation(sc, "Addition", Math::addExact);
            case 2 -> performBinaryOperation(sc, "Subtraction", Math::subtractExact);
            case 3 -> performBinaryOperation(sc, "Multiplication", Math::multiplyExact);
            case 4 -> performBinaryOperation(sc, "Division", Math::floorDiv);
            case 5 -> performBinaryOperation(sc, "Modulo", Math::floorMod);
            case 6 -> performUnaryOperation(sc, "Square", a -> (int) Math.pow(a, 2));
            case 7 -> performUnaryOperation(sc, "Cube", a -> (int) Math.pow(a, 3));
            case 8 -> performTrigonometryOperation(sc);
            default ->
                    System.out.println("\nInvalid Choice....\nPlease select a valid operation\n------------------------------------------");
        }
    }

    private void performBinaryOperation(Scanner sc, String operation, BinaryOperator<Integer> op) throws InterruptedException {
        System.out.println("Enter two numbers: ");
        int a = readWithTimeout(sc::nextInt);
        int b = readWithTimeout(sc::nextInt);
        int result = op.apply(a, b);
        System.out.println(operation + " result: " + result + "\n------------------------------------------");
    }

    private void performUnaryOperation(Scanner sc, String operation, UnaryOperator<Integer> op) throws InterruptedException {
        System.out.println("Enter a number: ");
        int a = readWithTimeout(sc::nextInt);
        int result = op.apply(a);
        System.out.println(operation + " result: " + result + "\n------------------------------------------");
    }

    private void performTrigonometryOperation(Scanner sc) throws InterruptedException {
        System.out.println("1. sin()");
        System.out.println("2. cos()");
        System.out.println("3. tan()");
        System.out.println("Select trigonometric operation...\n------------------------------------------");

        int choice = readWithTimeout(sc::nextInt);
        if (choice < 1 || choice > 3) {
            System.out.println("Invalid choice for trigonometry operation. Retry !!!\n");
            performTrigonometryOperation(sc);
        }
        System.out.println("Enter angle: ");
        double angle = readWithTimeout(sc::nextDouble);
        double result = switch (choice) {
            case 1 -> Math.sin(angle);
            case 2 -> Math.cos(angle);
            case 3 -> Math.tan(angle);
            default -> Double.NaN;
        };
        if (!Double.isNaN(result)) {
            System.out.println("Result: " + result + "\n------------------------------------------");
        }
    }

    public <T> T readWithTimeout(Callable<T> inputTask) throws InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<T> future = executor.submit(inputTask);
        try {
            return future.get(INACTIVITY_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        } catch (TimeoutException e) {
            System.err.println("\nNo input received for " + INACTIVITY_TIMEOUT_SECONDS + " seconds. Program terminated due to inactivity.");
            System.exit(1);
        } catch (ExecutionException e) {
            if (e.getCause() instanceof InputMismatchException) {
                System.err.println("User input error: Invalid input entered. Retry !!!\n");
                Thread.sleep(100);
                operations();
            }
        } finally {
            executor.shutdownNow();
        }
        return null;
    }
}