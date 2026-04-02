package org.s3m.leetcode.medium._48;


import java.util.Arrays;

public class SolutionJava48 {

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
        new SolutionJava48().rotate(matrix);
        System.out.println("Output:   " + Arrays.deepToString(matrix));
        System.out.println("Expected: [[7,4,1],[8,5,2],[9,6,3]]");

        // Example 2
        matrix = new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        System.out.println("Input:    " + Arrays.deepToString(matrix));
        new SolutionJava48().rotate(matrix);
        System.out.println("Output:   " + Arrays.deepToString(matrix));
        System.out.println("Expected: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]");
    }
}
