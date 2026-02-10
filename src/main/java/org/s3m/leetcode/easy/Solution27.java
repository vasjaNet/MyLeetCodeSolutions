package org.s3m.leetcode.easy;


import java.util.Arrays;

/**
 * Remove Element
 * <p>
 * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
 * Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:
 * Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
 * Return k.
 * <p>
 * Example 1:
 * Input: nums = [3,2,2,3], val = 3
 * Output: 2, nums = [2,2,_,_]
 * Explanation: Your function should return k = 2, with the first two elements of nums being 2.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 * Example 2:
 * Input: nums = [0,1,2,2,3,0,4,2], val = 2
 * Output: 5, nums = [0,1,4,0,3,_,_,_]
 * Explanation: Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
 * Note that the five elements can be returned in any order.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 */
public class Solution27 {

    public int removeElement(int[] nums, int val) {
        int end = nums.length;
        int i = 0;
        while(i < end) {
            if(nums[i] == val) {
                end--;
                for(int j = i; j < end; j++) {
                    nums[j] = nums[j+1];
                }
            } else {
                i++;
            }
        }
        return end;
    }

    public static void main(String[] args) {
        // Example 1
        int[] nums1 = {3,2,2,3};
        int m = 3;
        System.out.println("Input:    " + Arrays.toString(nums1));
        new Solution27().removeElement(nums1, m);
        System.out.println("Output:   " + Arrays.toString(nums1));
        System.out.println("Expected: [2,2]");

        // Example 2
        int[] nums2 = {0,1,2,2,3,0,4,2};
        m = 2;
        System.out.println("Input:    " + Arrays.toString(nums2));
        new Solution27().removeElement(nums2, m);
        System.out.println("Output:   " + Arrays.toString(nums2));
        System.out.println("Expected: [0,1,4,0,3]");

    }
}
