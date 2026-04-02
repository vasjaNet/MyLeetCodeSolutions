package org.s3m.leetcode.easy._530;


import org.s3m.leetcode.utils.TreeNode;

import java.util.*;

public class SolutionJava530 {

    //todo: optimize use additional variable
    public int getMinimumDifference(TreeNode root) {
        int[] sortedArray = bstToSortedArray(root);
        int min = Integer.MAX_VALUE;
        System.out.println(Arrays.toString(sortedArray));
        for (int i = 1; i < sortedArray.length; i++) {
            min = Math.min(min, sortedArray[i] - sortedArray[i - 1]);
        }
        return min;
    }

    public int[] bstToSortedArray(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inOrderCollect(root, result);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private void inOrderCollect(TreeNode node, java.util.List<Integer> result) {
        if (node == null) return;
        inOrderCollect(node.left, result);
        result.add(node.val);
        inOrderCollect(node.right, result);
    }



    public static void main(String[] args) {
        // Example 1
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(6));
        System.out.println("Input:    " + root);
        System.out.println("Output:   " + new SolutionJava530().getMinimumDifference(root));
        System.out.println("Expected: 1");

        // Example 2
        root = new TreeNode(1, new TreeNode(0), new TreeNode(48, new TreeNode(12), new TreeNode(49)));
        System.out.println("Input:    " + root);
        System.out.println("Output:   " + new SolutionJava530().getMinimumDifference(root));
        System.out.println("Expected: 1");


    }
}
