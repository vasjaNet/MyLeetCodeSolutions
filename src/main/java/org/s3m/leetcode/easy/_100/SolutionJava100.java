package org.s3m.leetcode.easy._100;

import org.s3m.leetcode.utils.TreeNode;

public class SolutionJava100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean result = true;
        if (p == q) return true;
        if (p == null || q == null) return false;
        if (p.val !=  q.val) return false;
        if (p.left != null && q.left != null ) {
            if (!isSameTree(p.left, q.left)) {
                return false;
            }
        } else if(p.left != q.left) {
            return false;
        }
        if (p.right != null && q.right != null ) {
            if (!isSameTree(p.right, q.right)) {
                return false;
            }
        } else if(p.right != q.right) {
            return false;
        }
        return result;
    }



    public static void main(String[] args) {
        // Example 1
        TreeNode p = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode q = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println("Input:    " + p + " and " + q);
        System.out.println("Output:   " + new SolutionJava100().isSameTree(p, q));
        System.out.println("Expected: true");

        // Example 2
        p = new TreeNode(1, new TreeNode(2), new TreeNode(1));
        q = new TreeNode(1, null, new TreeNode(1));
        System.out.println("Input:    " + p + " and " + q);
        System.out.println("Output:   " + new SolutionJava100().isSameTree(p, q));
        System.out.println("Expected: false");

        // Example 3
        p = new TreeNode(1, new TreeNode(2), new TreeNode(1));
        q = new TreeNode(1, new TreeNode(1), new TreeNode(2));
        System.out.println("Input:    " + p + " and " + q);
        System.out.println("Output:   " + new SolutionJava100().isSameTree(p, q));
        System.out.println("Expected: false");
    }
}
