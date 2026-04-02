package org.s3m.leetcode.medium;

/**
 * Maximal Square
 * <p>
 * Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 * <p>
 * Example 1:
 * Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * Output: 4
 * Example 2:
 * Input: matrix = [["0","1"],["1","0"]]
 * Output: 1
 * Example 3:
 * Input: matrix = [["0"]]
 * Output: 0
 */
public class Solution221 {

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
        System.out.println("Output:   " + new Solution221().maximalSquare(matrix));
        System.out.println("Expected: 4");

        // Example 2
        matrix = new char[][]{{'0','1'},{'1','0'}};
        System.out.println("Input:    " + matrix);
        System.out.println("Output:   " + new Solution221().maximalSquare(matrix));
        System.out.println("Expected: 1");

        // Example 3
        matrix = new char[][]{{'0'}};
        System.out.println("Input:    " + matrix);
        System.out.println("Output:   " + new Solution221().maximalSquare(matrix));
        System.out.println("Expected: 0");

    }
}
