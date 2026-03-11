package org.s3m.leetcode.easy;

import java.util.ArrayDeque;
import java.util.Deque;
import org.s3m.leetcode.utils.TreeNode;

/**
 * Path Sum
 * <p>
 * Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
 * A leaf is a node with no children.
 * <p>
 * Example 1:
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * Output: true
 * Explanation: The root-to-leaf path with the target sum is shown.
 * Example 2:
 * Input: root = [1,2,3], targetSum = 5
 * Output: false
 * Explanation: There are two root-to-leaf paths in the tree:
 * (1 --> 2): The sum is 3.
 * (1 --> 3): The sum is 4.
 * There is no root-to-leaf path with sum = 5.
 * Example 3:
 * Input: root = [], targetSum = 0
 * Output: false
 * Explanation: Since the tree is empty, there are no root-to-leaf paths.
 */
public class Solution112 {

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
        System.out.println("Output:   " + new Solution112().hasPathSum(root, targetSum));
        System.out.println("Expected: true");

        // Example 2
        root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        targetSum = 5;
        System.out.println("Input:    " + root + ", " + targetSum);
        System.out.println("Output:   " + new Solution112().hasPathSum(root, targetSum));
        System.out.println("Expected: false");

        // Example 3
        root = null;
        targetSum = 0;
        System.out.println("Input:    " + root + ", " + targetSum);
        System.out.println("Output:   " + new Solution112().hasPathSum(root, targetSum));
        System.out.println("Expected: false");


    }
}
