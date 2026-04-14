package org.s3m.leetcode.medium._189;

import org.s3m.leetcode.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionJava189 {

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        for (; i < j; ++i, --j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }


    public static void main(String[] args) {
        // Example 1
        int[] nums = {1,2,3,4,5,6,7};
        System.out.println("Input:    " + nums);
        new SolutionJava189().rotate(nums, 3);
        System.out.println("Output:   " + nums);
        System.out.println("Expected: [5,6,7,1,2,3,4]");

        // Example 2
        nums = new int[]{1,2,3,4,5,6,7};
        System.out.println("Input:    " + nums);
        new SolutionJava189().rotate(nums, 0);
        System.out.println("Output:   " + nums);
        System.out.println("Expected: [1,2,3,4,5,6,7]");

        // Example 3
        nums = new int[]{1,2,3,4,5,6,7};
        System.out.println("Input:    " + nums);
        new SolutionJava189().rotate(nums, 7);
        System.out.println("Output:   " + nums);
        System.out.println("Expected: [4,5,6,7,1,2,3]");
    }
}
