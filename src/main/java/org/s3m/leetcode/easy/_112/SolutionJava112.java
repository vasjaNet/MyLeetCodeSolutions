package org.s3m.leetcode.easy._112;

import java.util.ArrayDeque;
import java.util.Deque;
import org.s3m.leetcode.utils.TreeNode;

public class SolutionJava112 {

    record Entry(TreeNode node, int sum){}

    //todo: optimize use recursion
    public boolean hasPathSum(TreeNode root, int targetSum) {
        boolean result = false;
        if(root == null) return result;
        Deque<Entry> stack = new ArrayDeque<>();
        stack.push(new Entry(root, root.val));
        while(!stack.isEmpty()) {
            Entry cur = stack.pop();
            if(cur.node.left == null && cur.node.right == null) {
                if(cur.sum == targetSum) {
                    return true;
                }
            } else {
                if(cur.node.right != null)
                    stack.push(new Entry(cur.node.right, cur.sum + cur.node.right.val));
                if(cur.node.left != null)
                    stack.push(new Entry(cur.node.left, cur.sum + cur.node.left.val));
            }
        }
        return result;
    }

    public static void main(String[] args) {

        // Example 1
        TreeNode root = new TreeNode(5,
                new TreeNode(4,
                        new TreeNode(11,
                                new TreeNode(7), new TreeNode(2)
                        ), null),
                new TreeNode(8, null, new TreeNode(13))
        );
        int targetSum = 22;
        System.out.println("Input:    " + root + ", " + targetSum);
        System.out.println("Output:   " + new SolutionJava112().hasPathSum(root, targetSum));
        System.out.println("Expected: true");

        // Example 2
        root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        targetSum = 5;
        System.out.println("Input:    " + root + ", " + targetSum);
        System.out.println("Output:   " + new SolutionJava112().hasPathSum(root, targetSum));
        System.out.println("Expected: false");

        // Example 3
        root = null;
        targetSum = 0;
        System.out.println("Input:    " + root + ", " + targetSum);
        System.out.println("Output:   " + new SolutionJava112().hasPathSum(root, targetSum));
        System.out.println("Expected: false");


    }
}
