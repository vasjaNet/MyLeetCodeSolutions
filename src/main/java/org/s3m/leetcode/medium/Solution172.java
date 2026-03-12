package org.s3m.leetcode.medium;

/**
 * Factorial Trailing Zeroes
 * <p>
 * Example 1:
 * Input: n = 3
 * Output: 0
 * Explanation: 3! = 6, no trailing zero.
 * Example 2:
 * Input: n = 5
 * Output: 1
 * Explanation: 5! = 120, one trailing zero.
 * Example 3:
 * Input: n = 0
 * Output: 0
 */
public class Solution172 {

    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            n /= 5;
            count += n;
        }
        return count;
    }


    public static void main(String[] args) {
        Solution172 solution = new Solution172();

        // Example 1
        int n1 = 3;
        System.out.println("Input:    n = " + n1);
        System.out.println("Output:   " + solution.trailingZeroes(n1));
        System.out.println("Expected: 0");

        // Example 2
        int n2 = 5;
        System.out.println("\nInput:    n = " + n2);
        System.out.println("Output:   " + solution.trailingZeroes(n2));
        System.out.println("Expected: 1");

        // Example 3
        int n3 = 0;
        System.out.println("\nInput:    n = " + n3);
        System.out.println("Output:   " + solution.trailingZeroes(n3));
        System.out.println("Expected: 0");
    }
}
