package org.s3m.leetcode.medium;


import java.util.*;

/**
 * LRU Cache
 * <p>
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 * Implement the LRUCache class:
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 * The functions get and put must each run in O(1) average time complexity.
 * <p>
 * Example 1:
 * Input
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * Output
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 * Explanation
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // cache is {1=1}
 * lRUCache.put(2, 2); // cache is {1=1, 2=2}
 * lRUCache.get(1);    // return 1
 * lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
 * lRUCache.get(2);    // returns -1 (not found)
 * lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
 * lRUCache.get(1);    // return -1 (not found)
 * lRUCache.get(3);    // return 3
 * lRUCache.get(4);    // return 4
 */
public class Solution146 {

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
