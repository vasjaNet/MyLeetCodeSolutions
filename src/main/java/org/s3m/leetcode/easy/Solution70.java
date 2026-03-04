package org.s3m.leetcode.easy;


/**
 * Climbing Stairs
 * <p>
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Example 1:
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */
public class Solution70 {

    public int climbStairs(int n) {
        if(n < 3) return n;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        // Example 1
        int n = 2;
        System.out.println("Input:    " + n);
        System.out.println("Output:   " + new Solution70().climbStairs(n));
        System.out.println("Expected: 2");

        // Example 2
        n = 3;
        System.out.println("Input:    " + n);
        System.out.println("Output:   " + new Solution70().climbStairs(n));
        System.out.println("Expected: 3");
    }
}
