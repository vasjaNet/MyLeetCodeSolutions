package org.s3m.leetcode.medium._45;


import java.util.Arrays;

public class SolutionJava45 {

    public int jump(int[] nums) {
        int jumpCount = 0;
        int curPosition = 0;
        int maxJump = 0;
        for(int i = 0; i < nums.length-1; i++) {
            maxJump = Math.max(maxJump, i + nums[i]);
            if(maxJump >= nums.length-1){
                ++jumpCount;
                break;
            }
            if(i == curPosition) {
                ++jumpCount;
                curPosition = maxJump;
            }
        }
        return jumpCount;
    }


    public static void main(String[] args) {

        // Example 1
        int[] nums = {2,3,1,1,4};
        System.out.println("Input:    " + Arrays.toString(nums));
        System.out.println("Output:   " + new SolutionJava45().jump(nums));
        System.out.println("Expected: 2");

        // Example 2
        nums = new int[]{2,3,0,1,4};
        System.out.println("Input:    " + Arrays.toString(nums));
        System.out.println("Output:   " + new SolutionJava45().jump(nums));
        System.out.println("Expected: 2");

    }
}
