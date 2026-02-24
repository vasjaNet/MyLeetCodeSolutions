package org.s3m.leetcode.medium;


import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Populating Next Right Pointers in Each Node II
 * <p>
 * Given a binary tree
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * Initially, all next pointers are set to NULL.
 * <p>
 * Example 1:
 * Input: root = [1,2,3,4,5,null,7]
 * Output: [1,#,2,3,#,4,5,7,#]
 * Explanation: Given the above binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
 * Example 2:
 * Input: root = []
 * Output: []
 * Example 3:
 * Input: root = [1,2,null,3,null,4,null,5]
 * Output: [1,#,2,#,3,#,4,#,5,#]
 *
 */
public class Solution117 {

    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    //todo: optimize use just additional variable
    public Node connect(Node root) {
        Queue<Node> queue = new ArrayDeque<>();
        if(root == null) return null;
        queue.add(root);
        int count = 1;
        do {
            Node prev = null;
            int countInc = 0;
            for (int i = 0; i < count; i++) {
                var cur = queue.poll();
                if (prev != null) prev.next = cur;
                prev = cur;
                if(cur.left != null){
                    queue.add(cur.left);
                    countInc++;
                }
                if(cur.right != null) {
                    queue.add(cur.right);
                    countInc++;
                }
            }
            count = countInc;
        } while (count > 0);
        return root;
    }


    public static void main(String[] args) {

        // Example 1
        Node root = new Node(1, new Node(2, new Node(4), new Node(5), null),new Node(3, null,new Node(7), null), null);
        System.out.println("Input:    " + root);
        System.out.println("Output:   " + new Solution117().connect(root));
        System.out.println("Expected: [1,#,2,3,#,4,5,7,#]");

        // Example 2
        root = new Node();
        System.out.println("Input:    " + root);
        System.out.println("Output:   " + new Solution117().connect(root));
        System.out.println("Expected: []");

        // Example 3
        root = new Node(1, new Node(2, new Node(4), null, new Node(5)), null, new Node(3, new Node(6), new Node(7), null));
        System.out.println("Input:    " + root);
        System.out.println("Output:   " + new Solution117().connect(root));
        System.out.println("Expected: [1,#,2,3,#,4,#,5,#,6,#,7,#]");

    }
}
