package com.java.practice.dsa;

public class FindMiddleOfLinkedList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    Node findMiddle(Node head) {
        // Initialize the slow pointer to the head.
        Node slow = head;

        // Initialize the fast pointer to the head.
        Node fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        FindMiddleOfLinkedList middleOfLinkedList = new FindMiddleOfLinkedList();
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        Node middleNode = middleOfLinkedList.findMiddle(head);

        System.out.println("The middle node value is: " + middleNode.data);
    }
}