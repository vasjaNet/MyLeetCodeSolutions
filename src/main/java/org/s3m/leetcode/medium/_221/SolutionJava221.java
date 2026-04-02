package org.s3m.leetcode.medium._221;

public class SolutionJava221 {

    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        int mx = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == '1') {
                    dp[i + 1][j + 1] = Math.min(Math.min(dp[i][j + 1], dp[i + 1][j]), dp[i][j]) + 1;
                    mx = Math.max(mx, dp[i + 1][j + 1]);
                }
            }
        }
        return mx * mx;
    }

    public static void main(String[] args) {

        // Example 1
        char[][] matrix =  new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println("Input:    " + matrix);
        System.out.println("Output:   " + new SolutionJava221().maximalSquare(matrix));
        System.out.println("Expected: 4");

        // Example 2
        matrix = new char[][]{{'0','1'},{'1','0'}};
        System.out.println("Input:    " + matrix);
        System.out.println("Output:   " + new SolutionJava221().maximalSquare(matrix));
        System.out.println("Expected: 1");

        // Example 3
        matrix = new char[][]{{'0'}};
        System.out.println("Input:    " + matrix);
        System.out.println("Output:   " + new SolutionJava221().maximalSquare(matrix));
        System.out.println("Expected: 0");

    }
}
