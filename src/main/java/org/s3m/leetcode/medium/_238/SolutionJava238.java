package org.s3m.leetcode.medium._238;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SolutionJava238 {

    public int[] productExceptSelf(int[] nums) {
        int zeroIndex = -1;
        int product = 1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                if(zeroIndex != -1) return new int[nums.length];
                zeroIndex = i;
            } else {
                product *= nums[i];
            }
        }
        if(zeroIndex != -1) {
            int[] r = new int[nums.length];
            r[zeroIndex] = product;
            return r;
        }
        for(int i = 0; i < nums.length; i++) {
            nums[i] = product / nums[i];
        }

        return nums;
    }

    public static void main(String[] args) {

        // Example 1
        int[] nums = {1,2,3,4};
        System.out.println("Input:    " + Arrays.toString(nums));
        System.out.println("Output:   " + Arrays.toString(new SolutionJava238().productExceptSelf(nums)));
        System.out.println("Expected: [24,12,8,6]");

        // Example 2
        nums = new int[]{-1,1,0,-3,3};
        System.out.println("Input:    " + Arrays.toString(nums));
        System.out.println("Output:   " + Arrays.toString(new SolutionJava238().productExceptSelf(nums)));
        System.out.println("Expected: [0,0,9,0,0]");




    }
}
