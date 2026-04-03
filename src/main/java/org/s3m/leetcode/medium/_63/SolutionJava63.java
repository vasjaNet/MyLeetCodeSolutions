package org.s3m.leetcode.medium._63;


public class SolutionJava63 {

    private Integer[][] dp;
    private int[][] obstacleGrid;
    private int m;
    private int n;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        m = obstacleGrid.length;
        n = obstacleGrid[0].length;
        this.obstacleGrid = obstacleGrid;
        dp = new Integer[m][n];
        return dfs(0, 0);
    }

    private int dfs(int i, int j) {
        if (i >= m || j >= n || obstacleGrid[i][j] == 1) {
            return 0;
        }
        if (i == m - 1 && j == n - 1) {
            return 1;
        }
        if (dp[i][j] == null) {
            dp[i][j] = dfs(i + 1, j) + dfs(i, j + 1);
        }
        return dp[i][j];
    }


    public static void main(String[] args) {

        // Example 1
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println("Input:    " + obstacleGrid);
        System.out.println("Output:   " + new SolutionJava63().uniquePathsWithObstacles(obstacleGrid));
        System.out.println("Expected: 2");

        // Example 2
        obstacleGrid = new int[][]{{0,1},{0,0}};
        System.out.println("Input:    " + obstacleGrid);
        System.out.println("Output:   " + new SolutionJava63().uniquePathsWithObstacles(obstacleGrid));
        System.out.println("Expected: 1");

    }
}
