package org.s3m.leetcode.medium._80;


import java.util.Arrays;

public class SolutionJava80 {

    public int removeDuplicates(int[] nums) {
        int end = nums.length;
        if(end <= 2) return nums.length;
        int i = 0;
        int k = i+1;
        int count = 0;
        while(k < nums.length) {
            if(nums[i] == nums[k]) {
                if(count < 1) {
                    i++;
                    nums[i] = nums[k];
                }
                k++;
                count++;
            } else {
                count=0;
                nums[i+1] = nums[k];
                i++;
                k++;
            }

        }
        return i+1;
    }

    public static void main(String[] args) {
        // Example 1
        int[] nums1 = {1,1,1,2,2,3};
        System.out.println("Input:    " + Arrays.toString(nums1));
        int count = new SolutionJava80().removeDuplicates(nums1);
        System.out.println("Output:   " + Arrays.toString(Arrays.copyOfRange(nums1, 0, count)));
        System.out.println("Expected: [1,1,2,2,3]");

        // Example 2
        int[] nums2 = {0,0,1,1,1,1,2,3,3};
        System.out.println("Input:    " + Arrays.toString(nums2));
        count =  new SolutionJava80().removeDuplicates(nums2);
        System.out.println("Output:   " + Arrays.toString(Arrays.copyOfRange(nums2, 0, count)));
        System.out.println("Expected: [0,0,1,1,2,3,3]");

    }
}
