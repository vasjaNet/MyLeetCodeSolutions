package org.s3m.leetcode.easy;

import org.s3m.leetcode.utils.TreeNode;


/**
 * Count Complete Tree Nodes
 * <p>
 * Given the root of a complete binary tree, return the number of the nodes in the tree.
 * According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 * Design an algorithm that runs in less than O(n) time complexity.
 * <p>
 * Example 1:
 * Input: root = [1,2,3,4,5,6]
 * Output: 6
 * Example 2:
 * Input: root = []
 * Output: 0
 * Example 3:
 * Input: root = [1]
 * Output: 1
 */
public class Solution222 {

    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int count = 0;
        if(!(root.left == null && root.right != null)) {
            count = 1;
        }
        int leftCount = countNodes(root.left);
        int rightCount = countNodes(root.right);
        return count + leftCount + rightCount;
    }


    public static void main(String[] args) {

        // Example 1
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), null));
        System.out.println("Input:    " + root);
        System.out.println("Output:   " + new Solution222().countNodes(root));
        System.out.println("Expected: 6");

        // Example 2
        root = null;
        System.out.println("Input:    " + root);
        System.out.println("Output:   " + new Solution222().countNodes(root));
        System.out.println("Expected: 0");

        // Example 3
        root = new TreeNode(1);
        System.out.println("Input:    " + root);
        System.out.println("Output:   " + new Solution222().countNodes(root));
        System.out.println("Expected: 1");

    }
}
