package org.s3m.leetcode.medium._15;


import java.util.*;

public class SolutionJava15 {

    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length < 3) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        int n = nums.length;

        for(int i = 0; i < n-2; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int j = i+1;
            int k = n-1;
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0) {
                    result.add(List.of(nums[i], nums[j], nums[k]));
                    while(j < k && nums[j] == nums[j+1]) j++;
                    while(j < k && nums[k] == nums[k-1]) k--;
                    j++;
                }
                else if(sum < 0) j++;
                else k--;
            }
        }

        return result;
    }


    public static void main(String[] args) {

        // Example 1
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println("Input:    " + Arrays.toString(nums));
        System.out.println("Output:   " + new SolutionJava15().threeSum(nums));
        System.out.println("Expected: [[-1,-1,2],[-1,0,1]]");

        // Example 2
        nums = new int[]{0,1,1};
        System.out.println("Input:    " + Arrays.toString(nums));
        System.out.println("Output:   " + new SolutionJava15().threeSum(nums));
        System.out.println("Expected: []");

        // Example 3
        nums = new int[]{0,0,0};
        System.out.println("Input:    " + Arrays.toString(nums));
        System.out.println("Output:   " + new SolutionJava15().threeSum(nums));
        System.out.println("Expected: [[0,0,0]]");

        // Example 4
        nums = new int[]{-100,-70,-60,110,120,130,160};
        System.out.println("Input:    " + Arrays.toString(nums));
        System.out.println("Output:   " + new SolutionJava15().threeSum(nums));
        System.out.println("Expected: [[-70, -60, 130], [-100, -60, 160]]");

        // Example 5
        nums = new int[]{-1,-4,1,2,0,-4};
        System.out.println("Input:    " + Arrays.toString(nums));
        System.out.println("Output:   " + new SolutionJava15().threeSum(nums));
        System.out.println("Expected: [[-1, 0, 1]]");

    }
}
