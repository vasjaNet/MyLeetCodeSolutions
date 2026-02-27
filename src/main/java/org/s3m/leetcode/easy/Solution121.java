package org.s3m.leetcode.easy;


import java.util.Arrays;

/**
 * Best Time to Buy and Sell Stock
 * <p>
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 * <p>
 * Example 1:
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 * Example 3:
 * Input: prices = [2,1,4]
 * Output: 3
 *
 */
public class Solution121 {

    public int maxProfit(int[] prices) {
        if( prices.length <=1) return 0;
        int l = 0;
        int r = 1;
        int maxDiff = Math.max((prices[r] - prices[l]), 0);
        while(r < prices.length) {
            if(prices[l] < prices[l+1]) {
                int curDiff = prices[r] - prices[l];
                maxDiff = Math.max(maxDiff, curDiff);
            } else {
                l=r;
            }
            r++;
        }
        return maxDiff;
    }

    public static void main(String[] args) {
        // Example 1
        int[] prices = {7,1,5,3,6,4};
        System.out.println("Input:    " + Arrays.toString(prices));
        System.out.println("Output:   " + new Solution121().maxProfit(prices));
        System.out.println("Expected: 5");

        // Example 2
        prices = new int[]{7,6,4,3,1};
        System.out.println("Input:    " + Arrays.toString(prices));
        System.out.println("Output:   " + new Solution121().maxProfit(prices));
        System.out.println("Expected: 0");

        // Example 3
        prices = new int[]{2,1,4};
        System.out.println("Input:    " + Arrays.toString(prices));
        System.out.println("Output:   " + new Solution121().maxProfit(prices));
        System.out.println("Expected: 3");

    }
}
