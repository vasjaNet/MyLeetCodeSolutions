package org.s3m.leetcode.easy._121;


import java.util.Arrays;

public class SolutionJava121 {

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
        System.out.println("Output:   " + new SolutionJava121().maxProfit(prices));
        System.out.println("Expected: 5");

        // Example 2
        prices = new int[]{7,6,4,3,1};
        System.out.println("Input:    " + Arrays.toString(prices));
        System.out.println("Output:   " + new SolutionJava121().maxProfit(prices));
        System.out.println("Expected: 0");

        // Example 3
        prices = new int[]{2,1,4};
        System.out.println("Input:    " + Arrays.toString(prices));
        System.out.println("Output:   " + new SolutionJava121().maxProfit(prices));
        System.out.println("Expected: 3");

    }
}
