package org.s3m.leetcode.easy;


import java.util.*;

/**
 * Single Number II
 * <p>
 * Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 * <p>
 * Example 1:
 * Input: nums = [2,2,3,2]
 * Output: 3
 * Example 2:
 * Input: nums = [0,1,0,1,0,1,99]
 * Output: 99
 */
public class Solution137 {

    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map  = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                int count = map.get(num);
                if (count == 2) {
                    map.remove(num);
                } else {
                    map.put(num, count + 1);
                }
            } else {
                map.put(num, 1);
            }
        }
        return map.keySet().iterator().next();
    }

    public static void main(String[] args) {
        // Example 1
        int[] nums1 = {2,2,3,2};
        System.out.println("Input:    " + Arrays.toString(nums1));
        System.out.println("Output:   " + new Solution137().singleNumber(nums1));
        System.out.println("Expected: 3");

        // Example 2
        int[] nums2 = {0,1,0,1,0,1,99};
        System.out.println("Input:    " + Arrays.toString(nums2));
        System.out.println("Output:   " + new Solution137().singleNumber(nums2));
        System.out.println("Expected: 99");
    }
}
