package org.s3m.leetcode.medium;


import java.util.Arrays;

/**
 * Remove Duplicates from Sorted Array II
 * <p>
 * Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice. The relative order of the elements should be kept the same.
 * Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
 * Return k after placing the final result in the first k slots of nums.
 * Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * Example 1:
 * beyond the returned k (hence they are underscores).
 * Example 2:
 * Input: nums = [0,0,1,1,1,1,2,3,3]
 * Output: 7, nums = [0,0,1,1,2,3,3,_,_]
 * Explanation: Your function should return k = 7, with the first seven elements of nums being 0, 0, 1, 1, 2, 3 and 3 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 */
public class Solution80 {

    public int removeDuplicates(int[] nums) {
        int end = nums.length;
        if(end <= 2) return nums.length;
        int i = 0;
        int k = i+1;
        int count = 0;
        while(k < nums.length) {
            if(nums[i] == nums[k]) {
                if(count < 1) {
                    i++;
                    nums[i] = nums[k];
                }
                k++;
                count++;
            } else {
                count=0;
                nums[i+1] = nums[k];
                i++;
                k++;
            }

        }
        return i+1;
    }

    public static void main(String[] args) {
        // Example 1
        int[] nums1 = {1,1,1,2,2,3};
        System.out.println("Input:    " + Arrays.toString(nums1));
        int count = new Solution80().removeDuplicates(nums1);
        System.out.println("Output:   " + Arrays.toString(Arrays.copyOfRange(nums1, 0, count)));
        System.out.println("Expected: [1,1,2,2,3]");

        // Example 2
        int[] nums2 = {0,0,1,1,1,1,2,3,3};
        System.out.println("Input:    " + Arrays.toString(nums2));
        count =  new Solution80().removeDuplicates(nums2);
        System.out.println("Output:   " + Arrays.toString(Arrays.copyOfRange(nums2, 0, count)));
        System.out.println("Expected: [0,0,1,1,2,3,3]");

    }
}
