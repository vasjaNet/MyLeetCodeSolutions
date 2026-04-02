package org.s3m.leetcode.easy._637;


import org.s3m.leetcode.utils.TreeNode;

import java.util.*;

public class SolutionJava637 {

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
        System.out.println("Output:   " + new SolutionJava637().averageOfLevels(root));
        System.out.println("Expected: [3.00000,14.50000,11.00000]");

        // Example 2
        root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println("Input:    " + root);
        System.out.println("Output:   " + new SolutionJava637().averageOfLevels(root));
        System.out.println("Expected: [3.00000,14.50000,11.00000]");


    }
}
