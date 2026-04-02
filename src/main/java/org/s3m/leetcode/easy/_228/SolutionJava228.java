package org.s3m.leetcode.easy._228;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionJava228 {

    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        if(n <= 0) return List.of();
        List<String> result = new ArrayList<>();
        int s = 0;
        String statr = String.valueOf(nums[s]);
        for(int i = 1; i < nums.length; i++) {
            if (nums[i-1] + 1 != nums[i]) {
                result.add(s==i-1 ? statr : nums[s] + "->" + nums[i-1]);
                s = i;
                statr = String.valueOf(nums[s]);
            }
        }
        result.add(s==n-1 ? statr : nums[s] + "->" + nums[n-1]);
        return result;
    }


    public static void main(String[] args) {

        // Example 1
        int[] nums1 = {0,1,2,4,5,7};
        System.out.println("Input:    " + Arrays.toString(nums1));
        System.out.println("Output:   " + new SolutionJava228().summaryRanges(nums1));
        System.out.println("Expected: [0->2,4->5,7]");

        // Example 2
        int[] nums2 = {0,2,3,4,6,8,9};
        System.out.println("Input:    " + Arrays.toString(nums2));
        System.out.println("Output:   " + new SolutionJava228().summaryRanges(nums2));
        System.out.println("Expected: [0,2->4,6,8->9]");

    }
}
