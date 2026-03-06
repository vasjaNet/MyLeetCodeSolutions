package org.s3m.leetcode.medium;


import java.util.Arrays;

/**
 * Number of Islands
 * <p>
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * Example 1:
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 * Example 2:
 * Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 */
public class Solution200 {

    public int numIslands(char[][] grid) {
        int numIslands = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; i++) {
            for(int j=0; j < n; j++) {
                if(grid[i][j] == '1' ) {
                    bfs(grid, i, j);
                    ++numIslands;
                }
            }
        }

        return numIslands;
    }

    private void bfs(char[][] grid, int i, int j) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') return;

        grid[i][j] = '0';
        bfs(grid, i-1, j);
        bfs(grid, i+1, j);
        bfs(grid, i, j-1);
        bfs(grid, i, j+1);

    }

    public static void main(String[] args) {

        // Example 1
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        System.out.println("Input:    " + Arrays.deepToString(grid));
        System.out.println("Output:   " + new Solution200().numIslands(grid));
        System.out.println("Expected: 1");

        // Example 2
        grid = new char[][] {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println("Input:    " + Arrays.deepToString(grid));
        System.out.println("Output:   " + new Solution200().numIslands(grid));
        System.out.println("Expected: 3");

    }
}
