package com.java.practice.multithreading;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

    private final Semaphore printerSemaphore;
    private final int numberOfPrinters;

    public SemaphoreDemo(int numberOfPrinters) {
        this.numberOfPrinters = numberOfPrinters;
        this.printerSemaphore = new Semaphore(numberOfPrinters);
        System.out.println("Printer service initialized with " + numberOfPrinters + " printers.");
    }

    public void printDocument(String documentName) {
        try {
            System.out.println(Thread.currentThread().getName() + " is requesting to print: " + documentName);
            printerSemaphore.acquire(); // Acquire a permit (a printer)
            System.out.println(Thread.currentThread().getName() + " acquired a printer and is printing: " + documentName);

            // Simulate printing time
            Thread.sleep(2000);

            System.out.println(Thread.currentThread().getName() + " finished printing: " + documentName);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println(Thread.currentThread().getName() + " printing interrupted.");
        } finally {
            printerSemaphore.release(); // Release the permit (the printer)
        }
    }

    public static void main(String[] args) {
        SemaphoreDemo service = new SemaphoreDemo(2); // Two available printers

        for (int i = 1; i <= 5; i++) {
             int docNum = i;
            new Thread(() -> service.printDocument("Document " + docNum), "User-" + i).start();
        }
    }
}
