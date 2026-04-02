package org.s3m.leetcode.medium._236;


import org.s3m.leetcode.utils.TreeNode;


public class SolutionJava236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null) return right;
        else if(right == null) return left;
        else return root;
    }


    public static void main(String[] args) {

        // Example 1
        TreeNode root = new TreeNode(3, new TreeNode(5, new TreeNode(1), new TreeNode(6)), new TreeNode(2, new TreeNode(0), new TreeNode(8, new TreeNode(7), new TreeNode(4))));
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(1);
        System.out.println("Input:    " + root + ", " + p + ", " + q);
        System.out.println("Output:   " + new SolutionJava236().lowestCommonAncestor(root, p, q));
        System.out.println("Expected: 3");

        // Example 2
        root = new TreeNode(3, new TreeNode(5, new TreeNode(1), new TreeNode(6)), new TreeNode(2, new TreeNode(0), new TreeNode(8, new TreeNode(7), new TreeNode(4))));
        p = new TreeNode(5);
        q = new TreeNode(4);
        System.out.println("Input:    " + root + ", " + p + ", " + q);
        System.out.println("Output:   " + new SolutionJava236().lowestCommonAncestor(root, p, q));
        System.out.println("Expected: 5");


    }
}
