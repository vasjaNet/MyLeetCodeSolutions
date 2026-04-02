package org.s3m.leetcode.easy._137;


import java.util.*;

public class SolutionJava137 {

    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map  = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                int count = map.get(num);
                if (count == 2) {
                    map.remove(num);
                } else {
                    map.put(num, count + 1);
                }
            } else {
                map.put(num, 1);
            }
        }
        return map.keySet().iterator().next();
    }

    public static void main(String[] args) {
        // Example 1
        int[] nums1 = {2,2,3,2};
        System.out.println("Input:    " + Arrays.toString(nums1));
        System.out.println("Output:   " + new SolutionJava137().singleNumber(nums1));
        System.out.println("Expected: 3");

        // Example 2
        int[] nums2 = {0,1,0,1,0,1,99};
        System.out.println("Input:    " + Arrays.toString(nums2));
        System.out.println("Output:   " + new SolutionJava137().singleNumber(nums2));
        System.out.println("Expected: 99");
    }
}
