package org.s3m.leetcode.easy;


import org.s3m.leetcode.utils.TreeNode;

import java.util.*;

/**
 * Average of Levels in Binary Tree
 * <p>
 * Given the root of a binary tree, return the average value of the nodes on each level in the form of an array. Answers within 10-5 of the actual answer will be accepted.
 * <p>
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [3.00000,14.50000,11.00000]
 * Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11.
 * Hence return [3, 14.5, 11].
 * Example 2:
 * Input: root = [3,9,20,15,7]
 * Output: [3.00000,14.50000,11.00000]
 */
public class Solution637 {

    public List<Double> averageOfLevels(TreeNode root) {
        if(root == null) return null;
        List<Double> result = new ArrayList<>();
        result.add((double) root.val);
        int prevLevelCount = 1;
        int curLevelCount = 0;
        double sum = 0.0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            prevLevelCount--;
            if(cur.left != null) {
                curLevelCount++;
                queue.add(cur.left);
                sum += cur.left.val;
            }
            if(cur.right != null) {
                queue.add(cur.right);
                curLevelCount++;
                sum += cur.right.val;
            }
            if(prevLevelCount == 0 && curLevelCount > 0) {
                result.add(sum / curLevelCount);
                sum = 0.0;
                prevLevelCount = curLevelCount;
                curLevelCount = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Example 1
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println("Input:    " + root);
        System.out.println("Output:   " + new Solution637().averageOfLevels(root));
        System.out.println("Expected: [3.00000,14.50000,11.00000]");

        // Example 2
        root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println("Input:    " + root);
        System.out.println("Output:   " + new Solution637().averageOfLevels(root));
        System.out.println("Expected: [3.00000,14.50000,11.00000]");


    }
}
