package org.s3m.leetcode.medium;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Binary Tree Zigzag Level Order Traversal
 * <p>
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).
 * <p>
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
 * Example 2:
 * Input: root = [1]
 * Output: [[1]]
 * Example 3:
 * Input: root = []
 * Output: []
 */
public class Solution103 {

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

    //todo: optimize use recursion
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        queue.add(root);
        List<Integer> tmp = List.of(root.val);
        result.add(tmp);
        boolean isOdd = true;
        while (!tmp.isEmpty()) {
            int size = tmp.size();
            tmp = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                var cur = queue.poll();
                if(cur.left != null) {
                    queue.add(cur.left);
                    tmp.add(cur.left.val);
                }
                if(cur.right != null) {
                    queue.add(cur.right);
                    tmp.add(cur.right.val);
                }
            }
            if(tmp.isEmpty()) break;
            isOdd = !isOdd;
            result.add(isOdd ? tmp : tmp.reversed());
        }
        return result;
    }


    public static void main(String[] args) {

        // Example 1
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        System.out.println("Input:    " + root1);
        System.out.println("Output:   " + new Solution103().zigzagLevelOrder(root1));
        System.out.println("Expected: [[3],[9,20],[15,7]]");

        // Example 2
        TreeNode root2 = new TreeNode(1);
        System.out.println("Input:    " + root2);
        System.out.println("Output:   " + new Solution103().zigzagLevelOrder(root2));
        System.out.println("Expected: [[1]]");

        // Example 3
        TreeNode root3 = null;
        System.out.println("Input:    " + root3);
        System.out.println("Output:   " + new Solution103().zigzagLevelOrder(root3));
        System.out.println("Expected: []");


    }
}
