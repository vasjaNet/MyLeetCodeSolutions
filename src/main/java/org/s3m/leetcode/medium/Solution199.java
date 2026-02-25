package org.s3m.leetcode.medium;


import java.util.*;

/**
 * Binary Tree Right Side View
 * <p>
 * Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 * <p>
 * Example 1:
 * Input: root = [1,2,3,null,5,null,4]
 * Output: [1,3,4]
 * Explanation:
 * Example 2:
 * Input: root = [1,2,3,4,null,null,null,5]
 * Output: [1,3,4,5]
 * Explanation:
 * Example 3:
 * Input: root = [1,null,3]
 * Output: [1,3]
 * Example 4:
 * Input: root = []
 * Output: []
 *
 */
public class Solution199 {

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

    public List<Integer> rightSideView(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        queue.add(root);
        int visiblwNode = root.val;
        result.add(visiblwNode);
        while (!queue.isEmpty()) {
            var cur = queue.poll();
            if(cur.left != null) {
                queue.add(cur.left);
            }
            if(cur.right != null) {
                queue.add(cur.right);
            }
            if(cur.val == visiblwNode && !queue.isEmpty()) {
                visiblwNode = queue.peekLast().val;
                result.add(visiblwNode);
            }
        }
        return result;
    }



    public static void main(String[] args) {

        // Example 1
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.right = new TreeNode(5);
        root1.right.right = new TreeNode(4);
        System.out.println("Input:    " + root1);
        System.out.println("Output:   " + new Solution199().rightSideView(root1));
        System.out.println("Expected: [1,3,4]");

        // Example 2
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.right = new TreeNode(5);
        root2.right.right = new TreeNode(4);
        System.out.println("Input:    " + root2);
        System.out.println("Output:   " + new Solution199().rightSideView(root2));
        System.out.println("Expected: [1,3,4,5]");

        // Example 3
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        root3.right = new TreeNode(3);
        System.out.println("Input:    " + root3);
        System.out.println("Output:   " + new Solution199().rightSideView(root3));
        System.out.println("Expected: [1,3]");

        // Example 4
        TreeNode root4 = null;
        System.out.println("Input:    " + root4);
        System.out.println("Output:   " + new Solution199().rightSideView(root4));
        System.out.println("Expected: []");

    }
}
