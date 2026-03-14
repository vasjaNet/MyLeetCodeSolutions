package org.s3m.leetcode.medium;


import java.util.Arrays;

/**
 * Search a 2D Matrix
 * <p>
 * You are given an m x n integer matrix matrix with the following two properties:
 * Each row is sorted in non-decreasing order.
 * The first integer of each row is greater than the last integer of the previous row.
 * Given an integer target, return true if target is in matrix or false otherwise.
 * You must write a solution in O(log(m * n)) time complexity.
 * <p>
 * Example 1:
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * Output: true
 * Example 2:
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * Output: false
 */
public class Solution74 {

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
        System.out.println("Output:   " + new Solution74().searchMatrix(matrix, target));
        System.out.println("Expected: true");

        // Exapmle 2
        matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        target = 13;
        System.out.println("Input:    " + Arrays.deepToString(matrix));
        System.out.println("Output:   " + new Solution74().searchMatrix(matrix, target));
        System.out.println("Expected: false");

    }
}
