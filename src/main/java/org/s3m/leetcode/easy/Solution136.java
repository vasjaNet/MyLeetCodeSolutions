package org.s3m.leetcode.easy;


import java.util.*;

/**
 * Single Number
 * <p>
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 * <p>
 * Example 1:
 * Input: nums = [2,2,1]
 * Output: 1
 * Example 2:
 * Input: nums = [4,1,2,1,2]
 * Output: 4
 * Example 3:
 * Input: nums = [1]
 * Output: 1
 */
public class Solution136 {

    public int singleNumber(int[] nums) {
        Set<Integer> set  = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        return set.iterator().next();
    }

    public static void main(String[] args) {
        // Example 1
        int[] nums = {2,2,1};
        System.out.println("Input:    " + Arrays.toString(nums));
        System.out.println("Output:   " + new Solution136().singleNumber(nums));
        System.out.println("Expected: 1");

        // Example 2
        nums = new int[]{4,1,2,1,2};
        System.out.println("Input:    " + Arrays.toString(nums));
        System.out.println("Output:   " + new Solution136().singleNumber(nums));
        System.out.println("Expected: 4");
    }
}
