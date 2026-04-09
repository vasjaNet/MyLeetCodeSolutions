package org.s3m.leetcode.easy._169;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SolutionJava169 {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            Integer e = nums[i];
            Integer count = map.get(e);
            if (count == null) {
                map.put(e, 1);
            } else {
                map.replace(e, count + 1);
            }
        }
        return map.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(0);
    }

    public static void main(String[] args) {
        // Example 1
        int[] nums = {3,2,3};
        System.out.println("Input:    " + Arrays.toString(nums));
        System.out.println("Output:   " + new SolutionJava169().majorityElement(nums));
        System.out.println("Expected: 3");

        // Example 2
        nums = new int[]{2,2,1,1,1,2,2};
        System.out.println("Input:    " + Arrays.toString(nums));
        System.out.println("Output:   " + new SolutionJava169().majorityElement(nums));
        System.out.println("Expected: 2");

        // Example 3
        nums = new int[]{1};
        System.out.println("Input:    " + Arrays.toString(nums));
        System.out.println("Output:   " + new SolutionJava169().majorityElement(nums));
        System.out.println("Expected: 1");
    }
}
