package org.s3m.leetcode.medium._198;

public class SolutionJava198 {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int prev2 = 0;
        int prev1 = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int current = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }

    public static void main(String[] args) {
        SolutionJava198 solution = new SolutionJava198();

        // Example 1
        int[] nums1 = {1, 2, 3, 1};
        System.out.println("Input:    " + java.util.Arrays.toString(nums1));
        System.out.println("Output:   " + solution.rob(nums1));
        System.out.println("Expected: 4");

        // Example 2
        int[] nums2 = {2, 7, 9, 3, 1};
        System.out.println("\nInput:    " + java.util.Arrays.toString(nums2));
        System.out.println("Output:   " + solution.rob(nums2));
        System.out.println("Expected: 12");
    }
}
