package org.s3m.leetcode.medium._55;


import java.util.Arrays;

public class SolutionJava55 {

    public boolean canJump(int[] nums) {
        int n = nums.length-1;
        if(n == 0) return true;
        int position = 0;
        int maxJump = 0;
        boolean isReach = false;
        while(position < n && position <= maxJump ) {
            maxJump = Math.max(maxJump, position+nums[position]);
            position++;
            if(maxJump >= n) {
                return true;
            }
        }
        return isReach;
    }


    public static void main(String[] args) {

        // Example 1
        int[] nums = {2,3,1,1,4};
        System.out.println("Input:    " + Arrays.toString(nums));
        System.out.println("Output:   " + new SolutionJava55().canJump(nums));
        System.out.println("Expected: true");

        // Example 2
        nums = new int[]{3,2,1,0,4};
        System.out.println("Input:    " + Arrays.toString(nums));
        System.out.println("Output:   " + new SolutionJava55().canJump(nums));
        System.out.println("Expected: false");
    }
}
