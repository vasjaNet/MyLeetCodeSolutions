package org.s3m.leetcode.medium._918;

import java.util.Arrays;

public class SolutionJava918 {

    //todo: think about optimize
    public int maxSubarraySumCircular(int[] nums) {
        final int inf = 1 << 30;
        int pmi = 0, pmx = -inf;
        int ans = -inf, s = 0, smi = Integer.MAX_VALUE;
        for (int x : nums) {
            s += x;
            ans = Math.max(ans, s - pmi);
            smi = Math.min(smi, s - pmx);
            pmi = Math.min(pmi, s);
            pmx = Math.max(pmx, s);
        }
        return Math.max(ans, s - smi);
    }


    public static void main(String[] args) {

        // Example 1
        int[] nums = {1,-2,3,-2};
        System.out.println("Input:    " + Arrays.toString(nums));
        System.out.println("Output:   " + new SolutionJava918().maxSubarraySumCircular(nums));
        System.out.println("Expected: 3");

        // Example 2
        nums = new int[]{5,-3,5};
        System.out.println("Input:    " + Arrays.toString(nums));
        System.out.println("Output:   " + new SolutionJava918().maxSubarraySumCircular(nums));
        System.out.println("Expected: 10");

        // Example 3
        nums = new int[]{-3,-2,-3};
        System.out.println("Input:    " + Arrays.toString(nums));
        System.out.println("Output:   " + new SolutionJava918().maxSubarraySumCircular(nums));
        System.out.println("Expected: -2");


    }
}
