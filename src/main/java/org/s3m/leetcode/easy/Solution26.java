package org.s3m.leetcode.easy;


import java.util.Arrays;

/**
 * Remove Duplicates from Sorted Array
 * <p>
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.
 * Consider the number of unique elements in nums to be k​​​​​​​​​​​​​​. After removing duplicates, return the number of unique elements k.
 * The first k elements of nums should contain the unique numbers in sorted order. The remaining elements beyond index k - 1 can be ignored.
 * <p>
 * Example 1:
 * Input: nums = [1,1,2]
 * Output: 2, nums = [1,2,_]
 * Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 * Example 2:
 * Input: nums = [0,0,1,1,1,2,2,3,3,4]
 * Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
 * Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 */
public class Solution26 {

    public int removeDuplicates(int[] nums) {
        if(nums.length <= 1) return nums.length;
        int i = 0;
        int k = i+1;
        while(k < nums.length) {
            if(nums[i] == nums[k]) {
                k++;
            } else {
                nums[i+1] = nums[k];
                i++;
            }
        }
        return i+1;
    }

    public static void main(String[] args) {
        // Example 1
        int[] nums1 = {1,1,2};
        System.out.println("Input:    " + Arrays.toString(nums1));
        int count = new Solution26().removeDuplicates(nums1);
        System.out.println("Output:   " + Arrays.toString(Arrays.copyOfRange(nums1, 0, count)));
        System.out.println("Expected: [1,2]");

        // Example 2
        int[] nums2 = {0,0,1,1,1,2,2,3,3,4};
        System.out.println("Input:    " + Arrays.toString(nums2));
        count =  new Solution26().removeDuplicates(nums2);
        System.out.println("Output:   " + Arrays.toString(Arrays.copyOfRange(nums2, 0, count)));

                System.out.println("Expected: [0,1,2,3,4]");

        // Example 3
        int[] nums3 = {1,2};
        System.out.println("Input:    " + Arrays.toString(nums3));
        count = new Solution26().removeDuplicates(nums3);
        System.out.println("Output:   " + Arrays.toString(Arrays.copyOfRange(nums3, 0, count)));
        System.out.println("Expected: [1,2]");

        // Example 4
        int[] nums4 = {1,1};
        System.out.println("Input:    " + Arrays.toString(nums4));
        count = new Solution26().removeDuplicates(nums4);
        System.out.println("Output:   " + Arrays.toString(Arrays.copyOfRange(nums4, 0, count)));
        System.out.println("Expected: [1]");

    }
}
