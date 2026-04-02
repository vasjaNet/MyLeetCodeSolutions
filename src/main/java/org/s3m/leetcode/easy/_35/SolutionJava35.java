package org.s3m.leetcode.easy._35;


import java.util.Arrays;

public class SolutionJava35 {

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        // Example 1
        int[] nums = {1,3,5,6};
        int target = 5;
        System.out.println("Input:    " + Arrays.toString(nums));
        System.out.println("Output:   " + new SolutionJava35().searchInsert(nums, target));
        System.out.println("Expected: 2");

        // Example 2
        nums = new int[]{1,3,5,6};
        target = 2;
        System.out.println("Input:    " + Arrays.toString(nums));
        System.out.println("Output:   " + new SolutionJava35().searchInsert(nums, target));
        System.out.println("Expected: 1");

        // Example 3
        nums = new int[]{1,3,5,6};
        target = 7;
        System.out.println("Input:    " + Arrays.toString(nums));
        System.out.println("Output:   " + new SolutionJava35().searchInsert(nums, target));
        System.out.println("Expected: 4");

    }
}
