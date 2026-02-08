package org.s3m.leetcode.easy;


import java.util.Arrays;

/**
 * Two Sum
 * <p>
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * <p>
 * Example 1:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 */
public class Solution1 {

    public static int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        for(int i = 0; i < length-1; i++) {
            for(int j = i+1; j < length; j++) {
                if((nums[i] + nums[j]) == target) {
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // Example 1
        int[] nums = {2,7,11,15};
        int target = 9;
        System.out.println("Input:    " + Arrays.toString(nums));
        System.out.println("Output:   " + Arrays.toString(twoSum(nums, target)));
        System.out.println("Expected: [0,1]");

        // Example 2
        nums = new int[]{3,2,4};
        target = 6;
        System.out.println("Input:    " + Arrays.toString(nums));
        System.out.println("Output:   " + Arrays.toString(twoSum(nums, target)));
        System.out.println("Expected: [1,2]");

        // Example 3
        nums = new int[]{3,3};
        target = 6;
        System.out.println("Input:    " + Arrays.toString(nums));
        System.out.println("Output:   " + Arrays.toString(twoSum(nums, target)));
        System.out.println("Expected: [0,1]");

    }
}
