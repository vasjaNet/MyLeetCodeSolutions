package org.s3m.leetcode.easy._27;


import java.util.Arrays;

public class SolutionJava27 {

    public int removeElement(int[] nums, int val) {
        int shift = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            if(shift > 0) {
                nums[i-shift] = nums[i];
            }
            if(nums[i] == val) {
                shift++;
            }
        }
        return n - shift;
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
