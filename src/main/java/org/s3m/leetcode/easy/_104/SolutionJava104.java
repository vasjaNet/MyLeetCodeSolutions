package org.s3m.leetcode.easy._104;

import org.s3m.leetcode.utils.TreeNode;

public class SolutionJava104 {

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int max = 0;
        int left = 1;
        int right = 1;
        if(root.left != null) {
            left = maxDepth(root.left) + 1;
        }
        if(root.right != null) {
            right = maxDepth(root.right) + 1;
        }
        max+= Math.max(left, right);
        return max;
    }

    public static void main(String[] args) {
        // Example 1
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println("Input:    " + root);
        System.out.println("Output:   " + new SolutionJava104().maxDepth(root));
        System.out.println("Expected: 3");

        // Example 2
        root = new TreeNode(1, null, new TreeNode(2));
        System.out.println("Input:    " + root);
        System.out.println("Output:   " + new SolutionJava104().maxDepth(root));
        System.out.println("Expected: 2");

    }
}
