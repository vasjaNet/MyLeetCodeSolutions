package org.s3m.leetcode.medium;


import java.util.*;

/**
 * 3Sum
 * <p>
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * Notice that the solution set must not contain duplicate triplets.
 * <p>
 * Example 1:
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 * Example 2:
 * Input: nums = [0,1,1]
 * Output: []
 * Explanation: The only possible triplet does not sum up to 0.
 * Example 3:
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 * Explanation: The only possible triplet sums up to 0.
 */
public class Solution15 {

    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length < 3) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        int n = nums.length;

        for(int i = 0; i < n-2; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int j = i+1;
            int k = n-1;
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0) {
                    result.add(List.of(nums[i], nums[j], nums[k]));
                    while(j < k && nums[j] == nums[j+1]) j++;
                    while(j < k && nums[k] == nums[k-1]) k--;
                    j++;
                }
                else if(sum < 0) j++;
                else k--;
            }
        }

        return result;
    }


    public static void main(String[] args) {

        // Example 1
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println("Input:    " + Arrays.toString(nums));
        System.out.println("Output:   " + new Solution15().threeSum(nums));
        System.out.println("Expected: [[-1,-1,2],[-1,0,1]]");

        // Example 2
        nums = new int[]{0,1,1};
        System.out.println("Input:    " + Arrays.toString(nums));
        System.out.println("Output:   " + new Solution15().threeSum(nums));
        System.out.println("Expected: []");

        // Example 3
        nums = new int[]{0,0,0};
        System.out.println("Input:    " + Arrays.toString(nums));
        System.out.println("Output:   " + new Solution15().threeSum(nums));
        System.out.println("Expected: [[0,0,0]]");

        // Example 4
        nums = new int[]{-100,-70,-60,110,120,130,160};
        System.out.println("Input:    " + Arrays.toString(nums));
        System.out.println("Output:   " + new Solution15().threeSum(nums));
        System.out.println("Expected: [[-70, -60, 130], [-100, -60, 160]]");

        // Example 5
        nums = new int[]{-1,-4,1,2,0,-4};
        System.out.println("Input:    " + Arrays.toString(nums));
        System.out.println("Output:   " + new Solution15().threeSum(nums));
        System.out.println("Expected: [[-1, 0, 1]]");

    }
}
