package org.s3m.leetcode.medium;


import java.util.Arrays;

/**
 * Coin Change
 * <p>
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * You may assume that you have an infinite number of each kind of coin.
 * <p>
 * Example 1:
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 * Input: coins = [2], amount = 3
 * Output: -1
 * Example 3:
 * Input: coins = [1], amount = 0
 * Output: 0
 */
public class Solution322 {

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
        System.out.println("Output:   " + new Solution322().coinChange(coins, amount));
        System.out.println("Expected: 3");

        // Example 2
        coins = new int[]{2};
        amount = 3;
        System.out.println("Input:    " + Arrays.toString(coins) + ", " + amount);
        System.out.println("Output:   " + new Solution322().coinChange(coins, amount));
        System.out.println("Expected: 2");

        // Example 3
        coins = new int[]{1};
        amount = 0;
        System.out.println("Input:    " + Arrays.toString(coins) + ", " + amount);
        System.out.println("Output:   " + new Solution322().coinChange(coins, amount));
        System.out.println("Expected: 0");


    }
}
