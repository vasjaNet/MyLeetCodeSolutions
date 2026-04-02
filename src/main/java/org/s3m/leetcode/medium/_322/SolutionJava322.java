package org.s3m.leetcode.medium._322;


import java.util.Arrays;

public class SolutionJava322 {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for(int coin : coins) {
            for(int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i-coin]+1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }



    public static void main(String[] args) {

        // Example 1
        int[] coins = {1,2,5};
        int amount = 11;
        System.out.println("Input:    " + Arrays.toString(coins) + ", " + amount);
        System.out.println("Output:   " + new SolutionJava322().coinChange(coins, amount));
        System.out.println("Expected: 3");

        // Example 2
        coins = new int[]{2};
        amount = 3;
        System.out.println("Input:    " + Arrays.toString(coins) + ", " + amount);
        System.out.println("Output:   " + new SolutionJava322().coinChange(coins, amount));
        System.out.println("Expected: 2");

        // Example 3
        coins = new int[]{1};
        amount = 0;
        System.out.println("Input:    " + Arrays.toString(coins) + ", " + amount);
        System.out.println("Output:   " + new SolutionJava322().coinChange(coins, amount));
        System.out.println("Expected: 0");


    }
}
