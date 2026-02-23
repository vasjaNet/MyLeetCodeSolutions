package org.s3m.leetcode.easy;



/**
 * Maximum Depth of Binary Tree
 * <p>
 * Given the root of a binary tree, return its maximum depth.
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * <p>
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 * Example 2:
 * Input: root = [1,null,2]
 * Output: 2
 */
public class Solution104 {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }

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
        System.out.println("Output:   " + new Solution104().maxDepth(root));
        System.out.println("Expected: 3");

        // Example 2
        root = new TreeNode(1, null, new TreeNode(2));
        System.out.println("Input:    " + root);
        System.out.println("Output:   " + new Solution104().maxDepth(root));
        System.out.println("Expected: 2");

    }
}
