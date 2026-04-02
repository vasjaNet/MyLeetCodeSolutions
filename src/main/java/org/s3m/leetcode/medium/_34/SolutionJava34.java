package org.s3m.leetcode.medium._34;


import java.util.Arrays;

public class SolutionJava34 {

    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                int rl = mid-1, rr = mid+1;
                while (rl >= 0 && nums[rl] == target) {
                    rl--;
                }
                while (rr < nums.length && nums[rr] == target) {
                    rr++;
                }
                result[0] = rl+1;
                result[1] = rr-1;
                break;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }



    public static void main(String[] args) {

        // Example 1
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        System.out.println("Input:    " + Arrays.toString(nums) + ", " + target);
        System.out.println("Output:   " + Arrays.toString(new SolutionJava34().searchRange(nums, target)));
        System.out.println("Expected: [3,4]");

        // Example 2
        nums = new int[]{5,7,7,8,8,10};
        target = 6;
        System.out.println("Input:    " + Arrays.toString(nums) + ", " + target);
        System.out.println("Output:   " + Arrays.toString(new SolutionJava34().searchRange(nums, target)));
        System.out.println("Expected: [-1,-1]");

        // Example 3
        nums = new int[]{};
        target = 0;
        System.out.println("Input:    " + Arrays.toString(nums) + ", " + target);
        System.out.println("Output:   " + Arrays.toString(new SolutionJava34().searchRange(nums, target)));
        System.out.println("Expected: [-1,-1]");



    }
}
