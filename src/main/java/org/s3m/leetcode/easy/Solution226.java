package org.s3m.leetcode.easy;



import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Invert Binary Tree
 * <p>
 * Given the root of a binary tree, invert the tree, and return its root.
 * <p>
 * Example 1:
 * Input: root = [4,2,7,1,3,6,9]
 * Output: [4,7,2,9,6,3,1]
 * Example 2:
 * Input: root = [2,1,3]
 * Output: [2,3,1]
 * Example 3:
 * Input: root = []
 * Output: []
 */
public class Solution226 {

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

    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            TreeNode tmp = cur.left;
            cur.left = cur.right;
            cur.right = tmp;
            if(cur.left != null) {
                queue.add(cur.left);
            }
            if(cur.right != null) {
                queue.add(cur.right);
            }
        }
        return root;
    }





    public static void main(String[] args) {
        // Example 1
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7, new TreeNode(6), new TreeNode(9)));
        System.out.println("Input:    " + root);
        System.out.println("Output:   " + new Solution226().invertTree(root));
        System.out.println("Expected: [4,7,2,9,6,3,1]");

        // Example 2
        root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        System.out.println("Input:    " + root);
        System.out.println("Output:   " + new Solution226().invertTree(root));
        System.out.println("Expected: [2,1,3]");

        // Example 3
        root = new TreeNode();
        System.out.println("Input:    " + root);
        System.out.println("Output:   " + new Solution226().invertTree(root));
        System.out.println("Expected: []");


    }
}
