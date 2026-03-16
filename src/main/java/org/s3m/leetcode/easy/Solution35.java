package org.s3m.leetcode.easy;


import java.util.Arrays;

/**
 * Search Insert Position
 * <p>
 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * Example 1:
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 * Example 2:
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 * Example 3:
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 */
public class Solution35 {

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        // Example 1
        int[] nums = {1,3,5,6};
        int target = 5;
        System.out.println("Input:    " + Arrays.toString(nums));
        System.out.println("Output:   " + new Solution35().searchInsert(nums, target));
        System.out.println("Expected: 2");

        // Example 2
        nums = new int[]{1,3,5,6};
        target = 2;
        System.out.println("Input:    " + Arrays.toString(nums));
        System.out.println("Output:   " + new Solution35().searchInsert(nums, target));
        System.out.println("Expected: 1");

        // Example 3
        nums = new int[]{1,3,5,6};
        target = 7;
        System.out.println("Input:    " + Arrays.toString(nums));
        System.out.println("Output:   " + new Solution35().searchInsert(nums, target));
        System.out.println("Expected: 4");

    }
}
