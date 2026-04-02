package org.s3m.leetcode.easy._27;


import java.util.Arrays;

public class SolutionJava27 {

    public int removeElement(int[] nums, int val) {
        int end = nums.length;
        int i = 0;
        while(i < end) {
            if(nums[i] == val) {
                end--;
                for(int j = i; j < end; j++) {
                    nums[j] = nums[j+1];
                }
            } else {
                i++;
            }
        }
        return end;
    }

    public static void main(String[] args) {
        // Example 1
        int[] nums1 = {3,2,2,3};
        int m = 3;
        System.out.println("Input:    " + Arrays.toString(nums1));
        new SolutionJava27().removeElement(nums1, m);
        System.out.println("Output:   " + Arrays.toString(nums1));
        System.out.println("Expected: [2,2]");

        // Example 2
        int[] nums2 = {0,1,2,2,3,0,4,2};
        m = 2;
        System.out.println("Input:    " + Arrays.toString(nums2));
        new SolutionJava27().removeElement(nums2, m);
        System.out.println("Output:   " + Arrays.toString(nums2));
        System.out.println("Expected: [0,1,4,0,3]");

    }
}
