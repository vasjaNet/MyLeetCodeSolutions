package org.s3m.leetcode.easy._136;


import java.util.*;

public class SolutionJava136 {

    public int singleNumber(int[] nums) {
        Set<Integer> set  = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        return set.iterator().next();
    }

    public static void main(String[] args) {
        // Example 1
        int[] nums = {2,2,1};
        System.out.println("Input:    " + Arrays.toString(nums));
        System.out.println("Output:   " + new SolutionJava136().singleNumber(nums));
        System.out.println("Expected: 1");

        // Example 2
        nums = new int[]{4,1,2,1,2};
        System.out.println("Input:    " + Arrays.toString(nums));
        System.out.println("Output:   " + new SolutionJava136().singleNumber(nums));
        System.out.println("Expected: 4");
    }
}
