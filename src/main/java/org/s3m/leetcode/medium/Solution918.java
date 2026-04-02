package org.s3m.leetcode.medium;

import java.util.Arrays;

/**
 * Maximum Sum Circular Subarray
 * <p>
 * Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.
 * A circular array means the end of the array connects to the beginning of the array. Formally, the next element of nums[i] is nums[(i + 1) % n] and the previous element of nums[i] is nums[(i - 1 + n) % n].
 * A subarray may only include each element of the fixed buffer nums at most once. Formally, for a subarray nums[i], nums[i + 1], ..., nums[j], there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.
 * <p>
 * Example 1:
 * Input: nums = [1,-2,3,-2]
 * Output: 3
 * Explanation: Subarray [3] has maximum sum 3.
 * Example 2:
 * Input: nums = [5,-3,5]
 * Output: 10
 * Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10.
 * Example 3:
 * Input: nums = [-3,-2,-3]
 * Output: -2
 * Explanation: Subarray [-2] has maximum sum -2.
 */
public class Solution918 {

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
        System.out.println("Output:   " + new Solution918().maxSubarraySumCircular(nums));
        System.out.println("Expected: 3");

        // Example 2
        nums = new int[]{5,-3,5};
        System.out.println("Input:    " + Arrays.toString(nums));
        System.out.println("Output:   " + new Solution918().maxSubarraySumCircular(nums));
        System.out.println("Expected: 10");

        // Example 3
        nums = new int[]{-3,-2,-3};
        System.out.println("Input:    " + Arrays.toString(nums));
        System.out.println("Output:   " + new Solution918().maxSubarraySumCircular(nums));
        System.out.println("Expected: -2");


    }
}
