package org.s3m.leetcode.medium._122;


import java.util.Arrays;

public class SolutionJava122 {

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
        System.out.println("Output:   " + new SolutionJava122().maxProfit(prices));
        System.out.println("Expected: 7");

        // Example 2
        prices = new int[]{1,2,3,4,5};
        System.out.println("Input:    " + Arrays.toString(prices));
        System.out.println("Output:   " + new SolutionJava122().maxProfit(prices));
        System.out.println("Expected: 4");

        // Example 3
        prices = new int[]{7,6,4,3,1};
        System.out.println("Input:    " + Arrays.toString(prices));
        System.out.println("Output:   " + new SolutionJava122().maxProfit(prices));
        System.out.println("Expected: 0");

    }
}
