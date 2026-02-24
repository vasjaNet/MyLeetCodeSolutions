package org.s3m.leetcode.easy;



/**
 * Same Tree
 * <p>
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 * <p>
 * Example 1:
 * Input: p = [1,2,3], q = [1,2,3]
 * Output: true
 * Example 2:
 * Input: p = [1,2], q = [1,null,2]
 * Output: false
 * Example 3:
 * Input: p = [1,2,1], q = [1,1,2]
 * Output: false
 */
public class Solution100 {

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
        System.out.println("Output:   " + new Solution100().isSameTree(p, q));
        System.out.println("Expected: true");

        // Example 2
        p = new TreeNode(1, new TreeNode(2), new TreeNode(1));
        q = new TreeNode(1, null, new TreeNode(1));
        System.out.println("Input:    " + p + " and " + q);
        System.out.println("Output:   " + new Solution100().isSameTree(p, q));
        System.out.println("Expected: false");

        // Example 3
        p = new TreeNode(1, new TreeNode(2), new TreeNode(1));
        q = new TreeNode(1, new TreeNode(1), new TreeNode(2));
        System.out.println("Input:    " + p + " and " + q);
        System.out.println("Output:   " + new Solution100().isSameTree(p, q));
        System.out.println("Expected: false");
    }
}
