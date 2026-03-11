package org.s3m.leetcode.medium;

import org.s3m.leetcode.utils.TreeNode;

/**
 * Sum Root to Leaf Numbers
 * <p>
 * You are given the root of a binary tree containing digits from 0 to 9 only.
 * Each root-to-leaf path in the tree represents a number.
 * For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
 * Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.
 * A leaf node is a node with no children.
 * <p>
 * Example 1:
 * Input: root = [1,2,3]
 * Output: 25
 * Explanation:
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Therefore, sum = 12 + 13 = 25.
 * Example 2:
 * Input: root = [4,9,0,5,1]
 * Output: 1026
 * Explanation:
 * The root-to-leaf path 4->9->5 represents the number 495.
 * The root-to-leaf path 4->9->1 represents the number 491.
 * The root-to-leaf path 4->0 represents the number 40.
 * Therefore, sum = 495 + 491 + 40 = 1026.
 */
public class Solution129 {

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int currentNum) {
        if (node == null) {
            return 0;
        }
        int newNum = currentNum * 10 + node.val;
        if (node.left == null && node.right == null) {
            return newNum;
        }
        return dfs(node.left, newNum) + dfs(node.right, newNum);
    }

    public static void main(String[] args) {

        // Example 1
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(new Solution129().sumNumbers(root));

        // Example 2
        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(0);
        treeNode.left.left = new TreeNode(5);
        treeNode.left.right = new TreeNode(1);

        System.out.println(new Solution129().sumNumbers(treeNode));

    }
}
