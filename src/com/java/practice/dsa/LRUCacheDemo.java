package com.java.practice.dsa;

import java.util.HashMap;
import java.util.Map;

/*
LRU Cache Ref:
https://www.youtube.com/watch?v=iuqZvajTOyA
https://www.youtube.com/watch?v=lZ5QuFLCVn0
*/

class LRUCache<K, V> {

    private final int capacity;
    private final Map<K, Node<K, V>> cacheMap;
    private final DoublyLinkedList<K, V> doublyLinkedList;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cacheMap = new HashMap<>();
        this.doublyLinkedList = new DoublyLinkedList<>();
    }

    public V get(K key) {
        if (!cacheMap.containsKey(key)) {
            return null; // Cache miss
        }
        Node<K, V> node = cacheMap.get(key);
        doublyLinkedList.moveToHead(node); // Mark as most recently used
        return node.value;
    }

    public void put(K key, V value) {
        if (cacheMap.containsKey(key)) {
            Node<K, V> node = cacheMap.get(key);
            node.value = value; // Update value
            doublyLinkedList.moveToHead(node); // Mark as most recently used
        } else {
            if (cacheMap.size() >= capacity) { // Cache is full
                // Evict least recently used
                Node<K, V> tailNode = doublyLinkedList.removeTail();
                if (tailNode != null) {
                    cacheMap.remove(tailNode.key);
                }
            }
            Node<K, V> newNode = new Node<>(key, value);
            doublyLinkedList.addHead(newNode); // Add new node as most recently used
            cacheMap.put(key, newNode);
        }
    }

    // Node class for the Doubly Linked List
    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> prev;
        Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    // Doubly Linked List implementation
    private static class DoublyLinkedList<K, V> {
        private Node<K, V> head;
        private Node<K, V> tail;

        public DoublyLinkedList() {
            // Sentinel nodes to simplify edge cases (empty list, adding/removing head/tail)
            head = new Node<>(null, null);
            tail = new Node<>(null, null);
            head.next = tail;
            tail.prev = head;
        }

        // Add a node to the head of the list (most recently used)
        public void addHead(Node<K, V> node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        // Remove a node from the list
        public void remove(Node<K, V> node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        // Move an existing node to the head
        public void moveToHead(Node<K, V> node) {
            remove(node);
            addHead(node);
        }

        // Remove and return the tail node (least recently used)
        public Node<K, V> removeTail() {
            if (tail.prev == head) { // List is empty
                return null;
            }
            Node<K, V> lastNode = tail.prev;
            remove(lastNode);
            return lastNode;
        }
    }
}

public class LRUCacheDemo {
    public static void main(String[] args) {
        LRUCache<Integer, String> lruCache = new LRUCache<>(3);

        lruCache.put(1, "One");
        lruCache.put(2, "Two");
        lruCache.put(3, "Three");

        System.out.println(lruCache.get(1)); // Output: One
        lruCache.put(4, "Four"); // Evicts key 2

        System.out.println(lruCache.get(2)); // Output: null (not found)
        System.out.println(lruCache.get(3)); // Output: Three
        System.out.println(lruCache.get(4)); // Output: Four
    }
}