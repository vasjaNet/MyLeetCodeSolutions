package org.s3m.leetcode.easy._70;


public class SolutionJava70 {

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
        System.out.println("Output:   " + new SolutionJava70().climbStairs(n));
        System.out.println("Expected: 2");

        // Example 2
        n = 3;
        System.out.println("Input:    " + n);
        System.out.println("Output:   " + new SolutionJava70().climbStairs(n));
        System.out.println("Expected: 3");
    }
}
