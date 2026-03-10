package org.s3m.leetcode.medium;


import java.util.Arrays;

/**
 * Best Time to Buy and Sell Stock II
 * <p>
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can sell and buy the stock multiple times on the same day, ensuring you never hold more than one share of the stock.
 * Find and return the maximum profit you can achieve.
 * <p>
 * Example 1:
 * Input: prices = [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * Total profit is 4 + 3 = 7.
 * Example 2:
 * Input: prices = [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 * Total profit is 4.
 * Example 3:
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.
 *
 */
public class Solution122 {

    public int maxProfit(int[] prices) {
        if( prices.length <=1) return 0;
        int l = 0;
        int r = 1;
        int maxDiff = Math.max(prices[r] - prices[l], 0);
        int sum = 0;
        while(r < prices.length) {
            int curDiff = prices[r] - prices[l];
            if(prices[l] < prices[r] && curDiff > maxDiff) {
                    maxDiff = curDiff;
            } else {
                sum += maxDiff;
                maxDiff = 0;
                l=r;
            }
            r++;
        }
        sum+=maxDiff;
        return sum;
    }

    public static void main(String[] args) {
        // Example 1
        int[] prices = {7,1,5,3,6,4};
        System.out.println("Input:    " + Arrays.toString(prices));
        System.out.println("Output:   " + new Solution122().maxProfit(prices));
        System.out.println("Expected: 7");

        // Example 2
        prices = new int[]{1,2,3,4,5};
        System.out.println("Input:    " + Arrays.toString(prices));
        System.out.println("Output:   " + new Solution122().maxProfit(prices));
        System.out.println("Expected: 4");

        // Example 3
        prices = new int[]{7,6,4,3,1};
        System.out.println("Input:    " + Arrays.toString(prices));
        System.out.println("Output:   " + new Solution122().maxProfit(prices));
        System.out.println("Expected: 0");

    }
}
