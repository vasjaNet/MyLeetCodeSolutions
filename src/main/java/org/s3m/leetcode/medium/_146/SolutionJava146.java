package org.s3m.leetcode.medium._146;


import java.util.*;

public class SolutionJava146 {

    static class Node {
        int key, val;
        Node prev, next;

        Node() {
        }

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    static class LRUCache {
        private int size;
        private final int capacity;
        private final Node head;
        private final Node tail;
        private final Map<Integer, Node> cache;
        public LRUCache(int capacity) {
            this.cache = new HashMap<>();
            this.tail = new Node();
            this.head = new Node();
            this.capacity = capacity;
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if(!cache.containsKey(key)) {
                return -1;
            }
            Node node = cache.get(key);
            evict(node);
            addToHead(node);
            return node.val;
        }

        public void put(int key, int value) {
            if (cache.containsKey(key)) {
                Node node = cache.get(key);
                evict(node);
                node.val = value;
                addToHead(node);
            } else {
                Node node = new Node(key, value);
                cache.put(key, node);
                addToHead(node);
                if (++size > capacity) {
                    node = tail.prev;
                    cache.remove(node.key);
                    evict(node);
                    --size;
                }
            }
        }

        private void evict(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void addToHead(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next = node;
            node.next.prev = node;
        }
    }


    public static void main(String[] args) {
        // Example 1
        LRUCache lRUCache = new LRUCache(2);

        lRUCache.put(1, 1);
        lRUCache.put(2, 2);
        System.out.println("Output:   " + lRUCache.get(1));
        System.out.println("Expected: 1");
        System.out.println("Output:   " + lRUCache.get(2));
        System.out.println("Expected: 2");
        lRUCache.put(3, 3);
        System.out.println("Output:   " + lRUCache.get(1));
        System.out.println("Expected: -1");
        lRUCache.put(4, 4);
        System.out.println("Output:   " + lRUCache.get(1));
        System.out.println("Expected: -1");
        System.out.println("Output:   " + lRUCache.get(3));
        System.out.println("Expected: 3");
        System.out.println("Output:   " + lRUCache.get(4));
        System.out.println("Expected: 4");

    }
}
