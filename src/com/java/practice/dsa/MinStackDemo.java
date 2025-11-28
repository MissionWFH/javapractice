package com.java.practice.dsa;

import java.util.Stack;

class MinStack {

    private final Stack<Integer> mainStack;
    private final Stack<Integer> minStack;

    public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        mainStack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        } else {
            // Push the current minimum again to maintain alignment with mainStack
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        if (!mainStack.isEmpty()) {
            mainStack.pop();
            minStack.pop(); // Pop from minStack to maintain alignment
        }
    }

    public int top() {
        if (!mainStack.isEmpty()) {
            return mainStack.peek();
        }
        throw new IllegalStateException("Stack is empty.");
    }

    public int getMin() {
        if (!minStack.isEmpty()) {
            return minStack.peek();
        }
        throw new IllegalStateException("Stack is empty.");
    }
}

public class MinStackDemo {

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(4);
        stack.push(9);
        stack.push(-1);
        stack.push(5);
        stack.push(-3);
        stack.push(1);
        stack.push(7);

        System.out.println("Stack Top Value-> " + stack.top());

        stack.pop();
        System.out.println("Stack top value after pop-> " + stack.top());

        System.out.println("Min Stack Value-> " + stack.getMin());
    }
}