package org.s3m.leetcode.medium;


import java.util.Arrays;

/**
 *  Minimum Size Subarray Sum
 * <p>
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 * <p>
 * Example 1:
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 * Example 2:
 * Input: target = 4, nums = [1,4,4]
 * Output: 1
 * Example 3:
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
 * Output: 0
 * Example 4:
 * Input: target = 15, nums = [1,2,3,4,5]
 * Output: 5
 */
public class Solution209 {

    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0] >= target ? 1 : 0;
        int l = 0;
        int r = 0;
        int minSize = Integer.MAX_VALUE;
        int size = 0;
        int sum = 0;
        while (r < n) {
            if(sum < target) {
                sum+= nums[r++];
                size++;
            }
            while( sum >= target) {
                minSize = Math.min(minSize, size);
                size--;
                sum-= nums[l++];
            }
        }
        return minSize == Integer.MAX_VALUE ? 0 : minSize;
    }

    public static void main(String[] args) {

        // Example 1
        int target = 7;
        int[] nums = {2,3,1,2,4,3};
        System.out.println("Input:    target = " + target + ", nums = " + Arrays.toString(nums));
        System.out.println("Output:   " + new Solution209().minSubArrayLen(target, nums));
        System.out.println("Expected: 2");

        // Example 2
        target = 4;
        nums = new int[]{1,4,4};
        System.out.println("Input:    target = " + target + ", nums = " + Arrays.toString(nums));
        System.out.println("Output:   " + new Solution209().minSubArrayLen(target, nums));
        System.out.println("Expected: 1");

        // Example 3
        target = 11;
        nums = new int[]{1,1,1,1,1,1,1,1};
        System.out.println("Input:    target = " + target + ", nums = " + Arrays.toString(nums));
        System.out.println("Output:   " + new Solution209().minSubArrayLen(target, nums));
        System.out.println("Expected: 0");

        // Example 4
        target = 15;
        nums = new int[]{1,2,3,4,5};
        System.out.println("Input:    target = " + target + ", nums = " + Arrays.toString(nums));
        System.out.println("Output:   " + new Solution209().minSubArrayLen(target, nums));
        System.out.println("Expected: 5");
    }
}
