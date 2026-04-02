package org.s3m.leetcode.easy._222;

import org.s3m.leetcode.utils.TreeNode;


public class SolutionJava222 {

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
        System.out.println("Output:   " + new SolutionJava222().countNodes(root));
        System.out.println("Expected: 6");

        // Example 2
        root = null;
        System.out.println("Input:    " + root);
        System.out.println("Output:   " + new SolutionJava222().countNodes(root));
        System.out.println("Expected: 0");

        // Example 3
        root = new TreeNode(1);
        System.out.println("Input:    " + root);
        System.out.println("Output:   " + new SolutionJava222().countNodes(root));
        System.out.println("Expected: 1");

    }
}
