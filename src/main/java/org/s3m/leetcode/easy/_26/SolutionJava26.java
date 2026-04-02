package org.s3m.leetcode.easy._26;


import java.util.Arrays;

public class SolutionJava26 {

    public int removeDuplicates(int[] nums) {
        if(nums.length <= 1) return nums.length;
        int i = 0;
        int k = i+1;
        while(k < nums.length) {
            if(nums[i] == nums[k]) {
                k++;
            } else {
                nums[i+1] = nums[k];
                i++;
            }
        }
        return i+1;
    }

    public static void main(String[] args) {
        // Example 1
        int[] nums1 = {1,1,2};
        System.out.println("Input:    " + Arrays.toString(nums1));
        int count = new SolutionJava26().removeDuplicates(nums1);
        System.out.println("Output:   " + Arrays.toString(Arrays.copyOfRange(nums1, 0, count)));
        System.out.println("Expected: [1,2]");

        // Example 2
        int[] nums2 = {0,0,1,1,1,2,2,3,3,4};
        System.out.println("Input:    " + Arrays.toString(nums2));
        count =  new SolutionJava26().removeDuplicates(nums2);
        System.out.println("Output:   " + Arrays.toString(Arrays.copyOfRange(nums2, 0, count)));

                System.out.println("Expected: [0,1,2,3,4]");

        // Example 3
        int[] nums3 = {1,2};
        System.out.println("Input:    " + Arrays.toString(nums3));
        count = new SolutionJava26().removeDuplicates(nums3);
        System.out.println("Output:   " + Arrays.toString(Arrays.copyOfRange(nums3, 0, count)));
        System.out.println("Expected: [1,2]");

        // Example 4
        int[] nums4 = {1,1};
        System.out.println("Input:    " + Arrays.toString(nums4));
        count = new SolutionJava26().removeDuplicates(nums4);
        System.out.println("Output:   " + Arrays.toString(Arrays.copyOfRange(nums4, 0, count)));
        System.out.println("Expected: [1]");

    }
}
