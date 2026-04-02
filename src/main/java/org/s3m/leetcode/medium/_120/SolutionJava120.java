package org.s3m.leetcode.medium._120;


import java.util.List;

public class SolutionJava120 {

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
        System.out.println(new SolutionJava120().minimumTotal(triangle));
    }
}
