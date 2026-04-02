package org.s3m.leetcode.medium._53;

import java.util.Arrays;

public class SolutionJava53 {

    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int acum = 0;
        for (int num : nums) {
            acum += num;
            result = Math.max(result, acum);
            if (acum < 0) {
                acum = 0;
            }
        }
        return result;
    }


    public static void main(String[] args) {

        // Example 1
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("Input:    " + Arrays.toString(nums));
        System.out.println("Output:   " + new SolutionJava53().maxSubArray(nums));
        System.out.println("Expected: 6");

        // Example 2
        nums = new int[]{1};
        System.out.println("Input:    " + Arrays.toString(nums));
        System.out.println("Output:   " + new SolutionJava53().maxSubArray(nums));
        System.out.println("Expected: 1");

        // Example 3
        nums = new int[]{5,4,-1,7,8};
        System.out.println("Input:    " + Arrays.toString(nums));
        System.out.println("Output:   " + new SolutionJava53().maxSubArray(nums));
        System.out.println("Expected: 23");


    }
}
