package org.s3m.leetcode.medium;


import java.util.Arrays;

/**
 * Longest Increasing Subsequence
 * <p>
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 * <p>
 * Example 1:
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Example 2:
 * Input: nums = [0,1,0,3,2,3]
 * Output: 4
 * Example 3:
 * Input: nums = [7,7,7,7,7,7,7]
 * Output: 1
 */
public class Solution300 {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            //todo: add binary search
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }



    public static void main(String[] args) {

        // Example 1
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println("Input:    " + Arrays.toString(nums));
        System.out.println("Output:   " + new Solution300().lengthOfLIS(nums));
        System.out.println("Expected: 4");


        // Example 2
        nums = new int[]{0,1,0,3,2,3};
        System.out.println("Input:    " + Arrays.toString(nums));
        System.out.println("Output:   " + new Solution300().lengthOfLIS(nums));
        System.out.println("Expected: 4");

        // Example 3
        nums = new int[]{7,7,7,7,7,7,7};
        System.out.println("Input:    " + Arrays.toString(nums));
        System.out.println("Output:   " + new Solution300().lengthOfLIS(nums));
        System.out.println("Expected: 1");

    }
}
