package org.s3m.leetcode.medium;

/**
 * House Robber
 * <p>
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 * <p>
 * Example 1:
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 * Input: nums = [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 */
public class Solution198 {

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
        Solution198 solution = new Solution198();

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
