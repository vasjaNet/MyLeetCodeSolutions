package org.s3m.leetcode.medium;


import java.util.Arrays;

/**
 * Rotate Image
 * <p>
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 * <p>
 * Example 1:
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[7,4,1],[8,5,2],[9,6,3]]
 * Example 2:
 * Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 */
public class Solution48 {

    public void rotate(int[][] matrix) {
        for(int k = 0; k < (matrix.length / 2); k++) {
            int i = 0 + k;
            int j = (matrix.length-1) - k;

            for(int s = 0; s < j-i; s++) {
                int lt = matrix[i][i+s];
                matrix[i][i+s] = matrix[j-s][i];
                matrix[j-s][i] = matrix[j][j-s];
                matrix[j][j-s] = matrix[i+s][j];
                matrix[i+s][j] = lt;
            }
        }
    }

    public static void main(String[] args) {

        // Example 1
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println("Input:    " + Arrays.deepToString(matrix));
        new Solution48().rotate(matrix);
        System.out.println("Output:   " + Arrays.deepToString(matrix));
        System.out.println("Expected: [[7,4,1],[8,5,2],[9,6,3]]");

        // Example 2
        matrix = new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        System.out.println("Input:    " + Arrays.deepToString(matrix));
        new Solution48().rotate(matrix);
        System.out.println("Output:   " + Arrays.deepToString(matrix));
        System.out.println("Expected: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]");
    }
}
