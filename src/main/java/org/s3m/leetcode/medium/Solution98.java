package org.s3m.leetcode.medium;


import org.s3m.leetcode.utils.TreeNode;

import java.util.*;

/**
 * Validate Binary Search Tree
 * <p>
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 * A valid BST is defined as follows:
 * The left subtree of a node contains only nodes with keys strictly less than the node's key.
 * The right subtree of a node contains only nodes with keys strictly greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * <p>
 * Example 1:
 * Input: root = [2,1,3]
 * Output: true
 * Example 2:
 * Input: root = [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 */
public class Solution98 {

    private TreeNode prev;

    public boolean isValidBST(TreeNode root) {
        return dfs(root);
    }

    private boolean dfs(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!dfs(root.left)) {
            return false;
        }
        if (prev != null && prev.val >= root.val) {
            return false;
        }
        prev = root;
        return dfs(root.right);
    }

    public static void main(String[] args) {

        // Example 1
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        System.out.println("Input:    " + root);
        System.out.println("Output:   " + new Solution98().isValidBST(root));
        System.out.println("Expected: true");

        // Example 2
        root = new TreeNode(5, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(6)));
        System.out.println("Input:    " + root);
        System.out.println("Output:   " + new Solution98().isValidBST(root));
        System.out.println("Expected: false");

    }
}
