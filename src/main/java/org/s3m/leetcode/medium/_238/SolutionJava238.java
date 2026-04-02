package org.s3m.leetcode.medium._238;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SolutionJava238 {

    public int[] productExceptSelf(int[] nums) {
        Set<Integer> zeroIndexes = new HashSet<>();
        int product = 1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                zeroIndexes.add(i);
            } else {
                product *= nums[i];
            }
        }
        if(zeroIndexes.size() == nums.length) return new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            if(zeroIndexes.isEmpty()) {
                nums[i] = product / nums[i];
            } else {
                nums[i] = zeroIndexes.contains(i) ? product : 0;
            }
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
