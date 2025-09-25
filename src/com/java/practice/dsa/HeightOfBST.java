package com.java.practice.dsa;

public class HeightOfBST {

    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    Node root;

    public HeightOfBST() {
        root = null;
    }

    private int heightOfBST(Node root) {
        if (root == null) return 0;

        return 1 + Math.max(heightOfBST(root.left), heightOfBST(root.right));
    }

    public static void main(String[] args) {
        HeightOfBST tree = new HeightOfBST();

        // Insert nodes into the BST
        tree.root = new Node(50);
        tree.root.left = new Node(30);
        tree.root.right = new Node(70);
        tree.root.left.left = new Node(20);
        tree.root.left.right = new Node(40);
        tree.root.right.left = new Node(60);
        tree.root.right.right = new Node(80);
        tree.root.left.left.left = new Node(10); // Adding another level

        System.out.println("Height of the BST: " + tree.heightOfBST(tree.root)); // Expected output: 3 (0-indexed height)
    }
}