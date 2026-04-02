package org.s3m.leetcode.medium._98;


import org.s3m.leetcode.utils.TreeNode;

import java.util.*;

public class SolutionJava98 {

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
        System.out.println("Output:   " + new SolutionJava98().isValidBST(root));
        System.out.println("Expected: true");

        // Example 2
        root = new TreeNode(5, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(6)));
        System.out.println("Input:    " + root);
        System.out.println("Output:   " + new SolutionJava98().isValidBST(root));
        System.out.println("Expected: false");

    }
}
