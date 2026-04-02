package org.s3m.leetcode.easy._1;


import java.util.Arrays;

public class SolutionJava1 {

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
