package org.s3m.leetcode.medium;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Flatten Binary Tree to Linked List
 * <p>
 * Given the root of a binary tree, flatten the tree into a "linked list":
 * The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
 * The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 * <p>
 * Example 1:
 * Input: root = [1,2,5,3,4,null,6]
 * Output: [1,null,2,null,3,null,4,null,5,null,6]
 * Example 2:
 * Input: root = []
 * Output: []
 * Example 3:
 * Input: root = [0]
 * Output: [0]
 * Example 4:
 * Input: root = [1,2]
 * Output: [1,null,2]
 *
 */
public class Solution114 {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;


        public TreeNode() {}

        public TreeNode(int _val) {
            val = _val;
        }

        public TreeNode(int _val, TreeNode _left, TreeNode _right) {
            val = _val;
            left = _left;
            right = _right;

        }
    }

    public void flatten_(TreeNode root) {
        if(root == null) return;
        TreeNode cur = root;
        Deque<TreeNode> queue = new ArrayDeque<>();

        while(cur.right != null || cur.left != null || !queue.isEmpty()) {

            if(cur.left != null) {
                if(cur.right!=null)
                    queue.push(cur.right);
                cur.right = cur.left;
                cur.left = null;

            } else {
                if(cur.right == null) {
                    cur.right = queue.pop();
                }
            }
            cur = cur.right;
        }
    }

    public void flatten(TreeNode root) {
        TreeNode cur = root;
        while(cur != null) {
            if (cur.left != null) {
                TreeNode tmp = cur.left;
                while(tmp.right != null) {
                    tmp = tmp.right;
                }
                tmp.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }

            cur = cur.right;
        }
    }


    public static void main(String[] args) {

        // Example 1
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(5, null, new TreeNode(6)));
        System.out.println("Input:    " + root);
        new Solution114().flatten(root);
        System.out.println("Output:   " + root);
        System.out.println("Expected: [1,null,2,null,3,null,4,null,5,null,6]");

        // Example 2
        root = new TreeNode();
        System.out.println("Input:    " + root);
        new Solution114().flatten(root);
        System.out.println("Output:   " + root);
        System.out.println("Expected: []");

        // Example 3
        root = new TreeNode(0);
        System.out.println("Input:    " + root);
        new Solution114().flatten(root);
        System.out.println("Output:   " + root);
        System.out.println("Expected: [0]");

        // Example 4
        root = new TreeNode(1, new TreeNode(2), null);
        System.out.println("Input:    " + root);
        new Solution114().flatten(root);
        System.out.println("Output:   " + root);
        System.out.println("Expected: [1,null,2]");

    }
}
