package org.s3m.leetcode.medium._153;


import java.util.Arrays;

public class SolutionJava153 {

    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while(l < r) {
            int mid = (l + r) / 2;
            if(nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[l];
    }



    public static void main(String[] args) {

        // Example 1
        int[] nums = {3,4,5,1,2};
        System.out.println("Input:    " + Arrays.toString(nums));
        System.out.println("Output:   " + new SolutionJava153().findMin(nums));
        System.out.println("Expected: 1");

        // Example 2
        nums = new int[]{4,5,6,7,0,1,2};
        System.out.println("Input:    " + Arrays.toString(nums));
        System.out.println("Output:   " + new SolutionJava153().findMin(nums));
        System.out.println("Expected: 0");

        // Example 3
        nums = new int[]{11,13,15,17};
        System.out.println("Input:    " + Arrays.toString(nums));
        System.out.println("Output:   " + new SolutionJava153().findMin(nums));
        System.out.println("Expected: 11");

    }
}
