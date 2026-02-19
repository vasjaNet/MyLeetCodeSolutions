package org.s3m.leetcode.medium;


import java.util.*;

/**
 * Set Matrix Zeroes
 * <p>
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
 * You must do it in place.
 * <p>
 * Example 1:
 * Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * Output: [[1,0,1],[0,0,0],[1,0,1]]
 * Example 2:
 * Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 *
 */
public class Solution73 {

    public void setZeroes(int[][] matrix) {
        boolean[] zCols = new boolean[matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            boolean isZeroRow = false;
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0) {
                    isZeroRow = true;
                    zCols[j] = true;
                    for(int k = j; k >= 0; k--) {
                        matrix[i][k] = 0;
                    }
                    for(int k = i; k >= 0; k--) {
                        matrix[k][j] = 0;
                    }
                } else if(isZeroRow || zCols[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }


    public static void main(String[] args) {

        // Example 1
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        System.out.println("Input:    " + Arrays.deepToString(matrix));
        new Solution73().setZeroes(matrix);
        System.out.println("Output:   " + Arrays.deepToString(matrix));
        System.out.println("Expected: [[1,0,1],[0,0,0],[1,0,1]]");

        // Example 2
        matrix = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        System.out.println("Input:    " + Arrays.deepToString(matrix));
        new Solution73().setZeroes(matrix);
        System.out.println("Output:   " + Arrays.deepToString(matrix));
        System.out.println("Expected: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]");

    }
}
