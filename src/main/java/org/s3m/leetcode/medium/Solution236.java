package org.s3m.leetcode.medium;


import org.s3m.leetcode.utils.TreeNode;


/**
 * Lowest Common Ancestor of a Binary Tree
 * <p>
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 * <p>
 * Example 1:
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * Example 2:
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 * Example 3:
 * Input: root = [1,2], p = 1, q = 2
 * Output: 1
 *
 */
public class Solution236 {

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
        System.out.println("Output:   " + new Solution236().lowestCommonAncestor(root, p, q));
        System.out.println("Expected: 3");

        // Example 2
        root = new TreeNode(3, new TreeNode(5, new TreeNode(1), new TreeNode(6)), new TreeNode(2, new TreeNode(0), new TreeNode(8, new TreeNode(7), new TreeNode(4))));
        p = new TreeNode(5);
        q = new TreeNode(4);
        System.out.println("Input:    " + root + ", " + p + ", " + q);
        System.out.println("Output:   " + new Solution236().lowestCommonAncestor(root, p, q));
        System.out.println("Expected: 5");


    }
}
