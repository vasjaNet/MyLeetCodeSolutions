package org.s3m.leetcode.medium;


import java.util.Arrays;

/**
 * Jump Game
 * <p>
 * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
 * Return true if you can reach the last index, or false otherwise.
 * <p>
 * Example 1:
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 */
public class Solution55 {

    public boolean canJump(int[] nums) {
        int n = nums.length-1;
        if(n == 0) return true;
        int position = 0;
        int maxJump = 0;
        boolean isReach = false;
        while(position < n && position <= maxJump ) {
            maxJump = Math.max(maxJump, position+nums[position]);
            position++;
            if(maxJump >= n) {
                return true;
            }
        }
        return isReach;
    }


    public static void main(String[] args) {

        // Example 1
        int[] nums = {2,3,1,1,4};
        System.out.println("Input:    " + Arrays.toString(nums));
        System.out.println("Output:   " + new Solution55().canJump(nums));
        System.out.println("Expected: true");

        // Example 2
        nums = new int[]{3,2,1,0,4};
        System.out.println("Input:    " + Arrays.toString(nums));
        System.out.println("Output:   " + new Solution55().canJump(nums));
        System.out.println("Expected: false");
    }
}
