package org.s3m.leetcode.easy._108;

import org.s3m.leetcode.utils.TreeNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SolutionJava108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = null;
        if(nums.length == 0) return root;
        root = buildTree(nums, 0, nums.length - 1);
        return root;
    }

    private TreeNode buildTree(int[] nums, int start, int end) {
        if(start > end) return null;
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums, start, mid - 1);
        root.right = buildTree(nums, mid + 1, end);
        return root;
    }


    public static void main(String[] args) {

        // Example 1
        int[] nums = {-10,-3,0,5,9};
        System.out.println("Input:    " + Arrays.toString(nums));
        System.out.println("Output:   " + new SolutionJava108().sortedArrayToBST(nums));
        System.out.println("Expected: [0,-3,9,-10,null,5]");

        // Example 2
        nums = new int[]{1,3};
        System.out.println("Input:    " + Arrays.toString(nums));
        System.out.println("Output:   " + new SolutionJava108().sortedArrayToBST(nums));
        System.out.println("Expected: [3,1]");

    }
}
