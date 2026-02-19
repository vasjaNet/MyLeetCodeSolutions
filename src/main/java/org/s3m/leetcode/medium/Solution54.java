package org.s3m.leetcode.medium;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Spiral Matrix
 * <p>
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 * <p>
 * Example 1:
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 */
public class Solution54 {

    public List<Integer> spiralOrder(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> result = new ArrayList<>(m*n);
        if(m==1) {
            for(int i = 0; i < n; i++) {
                result.add(matrix[0][i]);
            }
            return result;
        }
        if(n==1) {
            for (int[] ints : matrix) {
                result.add(ints[0]);
            }
            return result;
        }

        int j = 0;
        int i = 0;
        int maxi = n-1;
        int mini = 0;
        int maxj = m-1;
        int minj = 0;
        while(mini <= maxi || minj <= maxj) {
            if(m*n == result.size()) return result;
            for (; i <= maxi; i++) {
                result.add(matrix[j][i]);
            }
            minj++;
            i--;
            j++;
            if(m*n == result.size()) return result;
            for (; j <= maxj; j++) {
                result.add(matrix[j][i]);
            }
            i--;
            j--;
            maxi--;
            if(m*n == result.size()) return result;
            for (; i >= mini; i--) {
                result.add(matrix[j][i]);
            }
            j--;
            i++;
            maxj--;
            if(m*n == result.size()) return result;
            for (; j >= minj; j--) {
                result.add(matrix[j][i]);
            }
            if(m*n == result.size()) return result;
            mini++;
            i++;
            j++;
            if(mini == maxi && minj == maxj) {
                result.add(matrix[j][i]);
                break;
            }
        }
        return result;
    }


    public static void main(String[] args) {

        // Example 1
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println("Input:    " + Arrays.deepToString(matrix));
        System.out.println("Output:   " + new Solution54().spiralOrder(matrix));
        System.out.println("Expected: [1, 2, 3, 6, 9, 8, 7, 4, 5]");

        // Example 2
        matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println("Input:    " + Arrays.deepToString(matrix));
        System.out.println("Output:   " + new Solution54().spiralOrder(matrix));
        System.out.println("Expected: [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]");

        // Example 3
        matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
        System.out.println("Input:    " + Arrays.deepToString(matrix));
        System.out.println("Output:   " + new Solution54().spiralOrder(matrix));
        System.out.println("Expected: [1, 2, 3, 6, 9, 12, 11, 10, 7, 4, 5, 8]");

        // Example 4
        matrix = new int[][]{{1,2,3}};
        System.out.println("Input:    " + Arrays.deepToString(matrix));
        System.out.println("Output:   " + new Solution54().spiralOrder(matrix));
        System.out.println("Expected: [1, 2, 3]");

        // Example 5 [
        matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16},{17,18,19,20},{21,22,23,24}};
        System.out.println("Input:    " + Arrays.deepToString(matrix));
        System.out.println("Output:   " + new Solution54().spiralOrder(matrix));
        System.out.println("Expected: [1, 2, 3, 4, 8, 12, 16, 20, 24, 23, 22, 21, 17, 13, 9, 5, 6, 7, 11, 15, 19, 18, 14, 10]");
    }
}
