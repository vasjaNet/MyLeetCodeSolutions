package org.s3m.leetcode.easy._219;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SolutionJava219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(k == 0) return false;
        boolean result = false;
        Set<Integer> set = new HashSet<>(k);
        set.add(nums[0]);
        for(int i = 1; i < nums.length; i++) {
            if(!set.add(nums[i])) {
                return true;
            }
            if(i >= k) {
                set.remove(nums[i-k]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Example 1
        int[] nums = {1,2,3,1};
        int k = 3;
        System.out.println("Input:    " + Arrays.toString(nums));
        System.out.println("Output:   " + new SolutionJava219().containsNearbyDuplicate(nums, k));
        System.out.println("Expected: true");

        // Example 2
        nums = new int[]{1,0,1,1};
        k = 1;
        System.out.println("Input:    " + Arrays.toString(nums));
        System.out.println("Output:   " + new SolutionJava219().containsNearbyDuplicate(nums, k));
        System.out.println("Expected: true");

        // Example 3
        nums = new int[]{1,2,3,1,2,3};
        k = 2;
        System.out.println("Input:    " + Arrays.toString(nums));
        System.out.println("Output:   " + new SolutionJava219().containsNearbyDuplicate(nums, k));
        System.out.println("Expected: false");

        // Example 3
        nums = new int[]{99,99};
        k = 2;
        System.out.println("Input:    " + Arrays.toString(nums));
        System.out.println("Output:   " + new SolutionJava219().containsNearbyDuplicate(nums, k));
        System.out.println("Expected: true");




    }
}
