package org.s3m.leetcode.medium;


import java.util.Arrays;

/**
 * Jump Game II
 * <p>
 * You are given a 0-indexed array of integers nums of length n. You are initially positioned at index 0.
 * Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at index i, you can jump to any index (i + j) where:
 * 0 <= j <= nums[i] and
 * i + j < n
 * Return the minimum number of jumps to reach index n - 1. The test cases are generated such that you can reach index n - 1.
 * <p>
 * Example 1:
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 * Input: nums = [2,3,0,1,4]
 * Output: 2
 */
public class Solution45 {

    public int jump(int[] nums) {
        int jumpCount = 0;
        int curPosition = 0;
        int maxJump = 0;
        for(int i = 0; i < nums.length-1; i++) {
            maxJump = Math.max(maxJump, i + nums[i]);
            if(maxJump >= nums.length-1){
                ++jumpCount;
                break;
            }
            if(i == curPosition) {
                ++jumpCount;
                curPosition = maxJump;
            }
        }
        return jumpCount;
    }


    public static void main(String[] args) {

        // Example 1
        int[] nums = {2,3,1,1,4};
        System.out.println("Input:    " + Arrays.toString(nums));
        System.out.println("Output:   " + new Solution45().jump(nums));
        System.out.println("Expected: 2");

        // Example 2
        nums = new int[]{2,3,0,1,4};
        System.out.println("Input:    " + Arrays.toString(nums));
        System.out.println("Output:   " + new Solution45().jump(nums));
        System.out.println("Expected: 2");

    }
}
