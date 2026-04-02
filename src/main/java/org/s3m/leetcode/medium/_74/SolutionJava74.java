package org.s3m.leetcode.medium._74;


import java.util.Arrays;

public class SolutionJava74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom) {
            int mid = top + (bottom - top) / 2;
            if (matrix[mid][left] <= target && target <= matrix[mid][right]) {
                while (left <= right) {
                    int mid2 = left + (right - left) / 2;
                    if (matrix[mid][mid2] == target) {
                        return true;
                    } else if (matrix[mid][mid2] < target) {
                        left = mid2 + 1;
                    } else {
                        right = mid2 - 1;
                    }
                }
            } else if (matrix[mid][left] < target) {
                top = mid + 1;
            } else {
                bottom = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        // Example 1
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;
        System.out.println("Input:    " + Arrays.deepToString(matrix));
        System.out.println("Output:   " + new SolutionJava74().searchMatrix(matrix, target));
        System.out.println("Expected: true");

        // Exapmle 2
        matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        target = 13;
        System.out.println("Input:    " + Arrays.deepToString(matrix));
        System.out.println("Output:   " + new SolutionJava74().searchMatrix(matrix, target));
        System.out.println("Expected: false");

    }
}
