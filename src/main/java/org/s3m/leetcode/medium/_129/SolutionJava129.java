package org.s3m.leetcode.medium._129;

import org.s3m.leetcode.utils.TreeNode;

public class SolutionJava129 {

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
        System.out.println(new SolutionJava129().sumNumbers(root));

        // Example 2
        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(0);
        treeNode.left.left = new TreeNode(5);
        treeNode.left.right = new TreeNode(1);

        System.out.println(new SolutionJava129().sumNumbers(treeNode));

    }
}
