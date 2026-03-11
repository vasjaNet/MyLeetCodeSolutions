package org.s3m.leetcode.medium;


import java.util.List;

/**
 * Triangle
 * <p>
 * Given a triangle array, return the minimum path sum from top to bottom.
 * For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.
 * <p>
 * Example 1:
 * Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * Output: 11
 * Explanation: The triangle looks like:
 *    2
 *   3 4
 *  6 5 7
 * 4 1 8 3
 * The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
 * Example 2:
 * Input: triangle = [[-10]]
 * Output: -10
 */
public class Solution120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if(n == 0) return 0;
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++){
            dp[n-1][i] = triangle.get(n-1).get(i);
        }
        for(int i = n-2; i >= 0; i--) {
            for(int j = 0; j < i+1; j++) {
                int cur =  triangle.get(i).get(j);
                dp[i][j] = Math.min(dp[i+1][j] + cur, dp[i+1][j+1] + cur);
            }
        }

        return dp[0][0];
    }


    public static void main(String[] args) {

        // Example 1
        List<List<Integer>> triangle = List.of(List.of(2), List.of(3,4), List.of(6,5,7), List.of(4,1,8,3));
        System.out.println(new Solution120().minimumTotal(triangle));
    }
}
