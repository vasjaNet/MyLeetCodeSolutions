package org.s3m.leetcode.easy;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Summary Ranges
 * <p>
 * You are given a sorted unique integer array nums.
 * A range [a,b] is the set of all integers from a to b (inclusive).
 * Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.
 * Each range [a,b] in the list should be output as:
 * "a->b" if a != b
 * "a" if a == b
 * <p>
 * Example 1:
 * Input: nums = [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Explanation: The ranges are:
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 * Example 2:
 * Input: nums = [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 * Explanation: The ranges are:
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 */
public class Solution228 {

    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        if(n <= 0) return List.of();
        List<String> result = new ArrayList<>();
        int s = 0;
        String statr = String.valueOf(nums[s]);
        for(int i = 1; i < nums.length; i++) {
            if (nums[i-1] + 1 != nums[i]) {
                result.add(s==i-1 ? statr : nums[s] + "->" + nums[i-1]);
                s = i;
                statr = String.valueOf(nums[s]);
            }
        }
        result.add(s==n-1 ? statr : nums[s] + "->" + nums[n-1]);
        return result;
    }


    public static void main(String[] args) {

        // Example 1
        int[] nums1 = {0,1,2,4,5,7};
        System.out.println("Input:    " + Arrays.toString(nums1));
        System.out.println("Output:   " + new Solution228().summaryRanges(nums1));
        System.out.println("Expected: [0->2,4->5,7]");

        // Example 2
        int[] nums2 = {0,2,3,4,6,8,9};
        System.out.println("Input:    " + Arrays.toString(nums2));
        System.out.println("Output:   " + new Solution228().summaryRanges(nums2));
        System.out.println("Expected: [0,2->4,6,8->9]");

    }
}
