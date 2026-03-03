package org.s3m.leetcode.easy;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Contains Duplicate II
 * <p>
 * Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
 * <p>
 * Example 1:
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 * Example 2:
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 * Example 3:
 * Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 */
public class Solution219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(k == 0) return false;
        boolean result = false;
        Set<Integer> set = new HashSet<>(k);
        set.add(nums[0]);
        for(int i = 1; i < nums.length; i++) {
            if(!set.add(nums[i])) {
                return true;
            }
            if(i >= k) {
                set.remove(nums[i-k]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Example 1
        int[] nums = {1,2,3,1};
        int k = 3;
        System.out.println("Input:    " + Arrays.toString(nums));
        System.out.println("Output:   " + new Solution219().containsNearbyDuplicate(nums, k));
        System.out.println("Expected: true");

        // Example 2
        nums = new int[]{1,0,1,1};
        k = 1;
        System.out.println("Input:    " + Arrays.toString(nums));
        System.out.println("Output:   " + new Solution219().containsNearbyDuplicate(nums, k));
        System.out.println("Expected: true");

        // Example 3
        nums = new int[]{1,2,3,1,2,3};
        k = 2;
        System.out.println("Input:    " + Arrays.toString(nums));
        System.out.println("Output:   " + new Solution219().containsNearbyDuplicate(nums, k));
        System.out.println("Expected: false");

        // Example 3
        nums = new int[]{99,99};
        k = 2;
        System.out.println("Input:    " + Arrays.toString(nums));
        System.out.println("Output:   " + new Solution219().containsNearbyDuplicate(nums, k));
        System.out.println("Expected: true");




    }
}
