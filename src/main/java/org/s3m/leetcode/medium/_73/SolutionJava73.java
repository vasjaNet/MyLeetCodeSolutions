package org.s3m.leetcode.medium._73;


import java.util.*;

public class SolutionJava73 {

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
        new SolutionJava73().setZeroes(matrix);
        System.out.println("Output:   " + Arrays.deepToString(matrix));
        System.out.println("Expected: [[1,0,1],[0,0,0],[1,0,1]]");

        // Example 2
        matrix = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        System.out.println("Input:    " + Arrays.deepToString(matrix));
        new SolutionJava73().setZeroes(matrix);
        System.out.println("Output:   " + Arrays.deepToString(matrix));
        System.out.println("Expected: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]");

    }
}
