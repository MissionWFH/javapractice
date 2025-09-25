package com.java.practice.dsa;

public class BinarySearchTree {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    Node root;

    public BinarySearchTree() {
        root = null;
    }

    // Method to insert a new node into the BST
    public void insert(int data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }
        // If data is equal, do nothing (assuming no duplicates)
        return root;
    }

    public boolean search(int data) {
        return searchRec(root, data) != null;
    }

    private Node searchRec(Node root, int data) {
        // Base Cases: root is null or key is present at root
        if (root == null || root.data == data) {
            return root;
        }

        // Key is greater than root's key
        if (root.data < data) {
            return searchRec(root.right, data);
        }

        // Key is smaller than root's key
        return searchRec(root.left, data);
    }

    public void delete(int data) {
        root = deleteRec(root, data);
    }

    private Node deleteRec(Node root, int data) {
        if (root == null) {
            return root; // Key not found
        }

        if (data < root.data) {
            root.left = deleteRec(root.left, data);
        } else if (data > root.data) {
            root.right = deleteRec(root.right, data);
        } else { // Node to be deleted found
            // Case 1 & 2: Node with 0 or 1 child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Case 3: Node with two children
            // Find in-order successor (smallest in right subtree)
            Node successor = findMin(root.right);
            root.data = successor.data; // Copy successor's value
            root.right = deleteRec(root.right, successor.data); // Delete successor
        }
        return root;
    }

    Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // Preorder Traversal (Root -> Left -> Right)
    public void preorderTraversal() {
        System.out.print("Preorder Traversal: ");
        preorderRec(root);
        System.out.println();
    }

    private void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.data + " -> ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    // Inorder Traversal (Left -> Root -> Right)
    public void inorderTraversal() {
        System.out.print("Inorder Traversal: ");
        inorderRec(root);
        System.out.println();
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " -> ");
            inorderRec(root.right);
        }
    }

    // Postorder Traversal (Left -> Right -> Root)
    public void postorderTraversal() {
        System.out.print("Postorder Traversal: ");
        postorderRec(root);
        System.out.println();
    }

    private void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.data + " -> ");
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(50);
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        bst.preorderTraversal();
        bst.inorderTraversal();
        bst.postorderTraversal();

        // Search for elements
        System.out.println("\nSearching for 40: " + bst.search(40));
        System.out.println("Searching for 90: " + bst.search(90));

        // Delete elements
        System.out.println("\nDeleting 20");
        bst.delete(20);
        bst.inorderTraversal();

        // Delete elements
        System.out.println("\nDeleting 50");
        bst.delete(50);
        bst.inorderTraversal();
    }
}