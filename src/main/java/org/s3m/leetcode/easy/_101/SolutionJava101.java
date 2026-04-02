package org.s3m.leetcode.easy._101;

import java.util.Deque;
import java.util.LinkedList;
import org.s3m.leetcode.utils.TreeNode;

public class SolutionJava101 {

    public boolean isSymmetric(TreeNode root) {
        Deque<TreeNode> queueLeft = new LinkedList<>();
        Deque<TreeNode> queueRight = new LinkedList<>();
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;
        if(root.left == null || root.right == null) return false;
        queueLeft.add(root.left);
        queueRight.add(root.right);
        while (!queueLeft.isEmpty() && !queueRight.isEmpty()) {
            TreeNode left = queueLeft.removeFirst();
            TreeNode right = queueRight.removeFirst();
            if(left == null && right == null) {
                continue;
            }
            if(left == null || right == null) {
                return false;
            }
            if(left.val != right.val) {
                return false;
            }
            queueLeft.addLast(left.left);
            queueLeft.addLast(left.right);
            queueRight.addLast(right.right);
            queueRight.addLast(right.left);
        }
        return queueLeft.isEmpty() && queueRight.isEmpty();
    }

    public static void main(String[] args) {

        // Example 1
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println("Input:    " + root);
        System.out.println("Output:   " + new SolutionJava101().isSymmetric(root));
        System.out.println("Expected: true");

        // Example 2
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        root.right.right.left = new TreeNode(5);
        System.out.println("Input:    " + root);
        System.out.println("Output:   " + new SolutionJava101().isSymmetric(root));
        System.out.println("Expected: false");

    }
}
