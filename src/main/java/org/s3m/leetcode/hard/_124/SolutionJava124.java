package org.s3m.leetcode.hard._124;

import org.s3m.leetcode.utils.TreeNode;


public class SolutionJava124 {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode node) {
        if(node == null) return 0;
        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0, dfs(node.right));
        max = Math.max(max, left + right + node.val );
        return node.val + Math.max(left, right);
    }


    public static void main(String[] args) {

        // Example 1
        TreeNode root = new TreeNode(1, new TreeNode(2),new TreeNode(3));
        System.out.println("Input:    " + root);
        System.out.println("Output:   " + new SolutionJava124().maxPathSum(root));
        System.out.println("Expected: 6");

        // Example 2
        root = new TreeNode(-10, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println("Input:    " + root);
        System.out.println("Output:   " + new SolutionJava124().maxPathSum(root));
        System.out.println("Expected: 42");

    }
}
