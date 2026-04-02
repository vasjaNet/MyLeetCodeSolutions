package org.s3m.leetcode.medium._138;


import java.util.*;

public class SolutionJava138 {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node tmp = head;
        while(head != null) {
            Node newNode = new Node(head.val);
            map.put(head, newNode);
            head = head.next;
        }
        head = tmp;
        while(head != null) {
            Node newNode = map.get(head);
            newNode.next = map.get(head.next);
            newNode.random = map.get(head.random);
            head = head.next;
        }
        return map.get(tmp);
    }


    public static void main(String[] args) {

        // Example 1
        Node head = new Node(7);
        head.next = new Node(13);
        head.next.next = new Node(11);
        head.next.next.next = new Node(10);
        head.next.next.next.next = new Node(1);
        System.out.println("Input:    " + head);
        System.out.println("Output:   " + new SolutionJava138().copyRandomList(head));
        System.out.println("Expected: [[7,null],[13,0],[11,4],[10,2],[1,0]]");

        // Example 2
        head = new Node(1);
        head.next = new Node(1);
        System.out.println("Input:    " + head);
        System.out.println("Output:   " + new SolutionJava138().copyRandomList(head));
        System.out.println("Expected: [[1,1],[2,1]]");


        // Example 3
        head = new Node(3);
        head.next = new Node(3);
        head.next.next = new Node(3);
        System.out.println("Input:    " + head);
        System.out.println("Output:   " + new SolutionJava138().copyRandomList(head));
        System.out.println("Expected: [[3,null],[3,0],[3,null]]");



    }
}
