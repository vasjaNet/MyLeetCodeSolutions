package org.s3m.leetcode.medium._209;


import java.util.Arrays;

public class SolutionJava209 {

    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0] >= target ? 1 : 0;
        int l = 0;
        int r = 0;
        int minSize = Integer.MAX_VALUE;
        int size = 0;
        int sum = 0;
        while (r < n) {
            if(sum < target) {
                sum+= nums[r++];
                size++;
            }
            while( sum >= target) {
                minSize = Math.min(minSize, size);
                size--;
                sum-= nums[l++];
            }
        }
        return minSize == Integer.MAX_VALUE ? 0 : minSize;
    }

    public static void main(String[] args) {

        // Example 1
        int target = 7;
        int[] nums = {2,3,1,2,4,3};
        System.out.println("Input:    target = " + target + ", nums = " + Arrays.toString(nums));
        System.out.println("Output:   " + new SolutionJava209().minSubArrayLen(target, nums));
        System.out.println("Expected: 2");

        // Example 2
        target = 4;
        nums = new int[]{1,4,4};
        System.out.println("Input:    target = " + target + ", nums = " + Arrays.toString(nums));
        System.out.println("Output:   " + new SolutionJava209().minSubArrayLen(target, nums));
        System.out.println("Expected: 1");

        // Example 3
        target = 11;
        nums = new int[]{1,1,1,1,1,1,1,1};
        System.out.println("Input:    target = " + target + ", nums = " + Arrays.toString(nums));
        System.out.println("Output:   " + new SolutionJava209().minSubArrayLen(target, nums));
        System.out.println("Expected: 0");

        // Example 4
        target = 15;
        nums = new int[]{1,2,3,4,5};
        System.out.println("Input:    target = " + target + ", nums = " + Arrays.toString(nums));
        System.out.println("Output:   " + new SolutionJava209().minSubArrayLen(target, nums));
        System.out.println("Expected: 5");
    }
}
