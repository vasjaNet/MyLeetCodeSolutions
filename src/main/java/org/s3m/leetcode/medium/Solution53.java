package org.s3m.leetcode.medium;

import java.util.Arrays;

/**
 * Maximum Subarray
 * <p>
 * Given an integer array nums, find the subarray with the largest sum, and return its sum.
 * <p>
 * Example 1:
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
 * Example 2:
 * Input: nums = [1]
 * Output: 1
 * Explanation: The subarray [1] has the largest sum 1.
 * Example 3:
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 * Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 */
public class Solution53 {

    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int acum = 0;
        for (int num : nums) {
            acum += num;
            result = Math.max(result, acum);
            if (acum < 0) {
                acum = 0;
            }
        }
        return result;
    }


    public static void main(String[] args) {

        // Example 1
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("Input:    " + Arrays.toString(nums));
        System.out.println("Output:   " + new Solution53().maxSubArray(nums));
        System.out.println("Expected: 6");

        // Example 2
        nums = new int[]{1};
        System.out.println("Input:    " + Arrays.toString(nums));
        System.out.println("Output:   " + new Solution53().maxSubArray(nums));
        System.out.println("Expected: 1");

        // Example 3
        nums = new int[]{5,4,-1,7,8};
        System.out.println("Input:    " + Arrays.toString(nums));
        System.out.println("Output:   " + new Solution53().maxSubArray(nums));
        System.out.println("Expected: 23");


    }
}
