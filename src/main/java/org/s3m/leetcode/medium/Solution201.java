package org.s3m.leetcode.medium;

import org.s3m.leetcode.utils.ListNode;

import java.util.Arrays;

/**
 * Bitwise AND of Numbers Range
 * <p>
 * Given two integers left and right that represent the range [left, right], return the bitwise AND of all numbers in this range, inclusive.
 * <p>
 * Example 1:
 * Input: left = 5, right = 7
 * Output: 4
 * Example 2:
 * Input: left = 0, right = 0
 * Output: 0
 * Example 3:
 * Input: left = 1, right = 2147483647
 * Output: 0
 */
public class Solution201 {

    public int rangeBitwiseAnd(int left, int right) {
        int shift =0;
        while(left < right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }
        left <<= shift;
        return left;
    }

    public static void main(String[] args) {

        // Example 1
        int left = 5, right = 7;
        System.out.println("Input:    " + left + ", " + right);
        System.out.println("Output:   " + new Solution201().rangeBitwiseAnd(left, right));
        System.out.println("Expected: 4");

        // Example 2
        left = 0;
        right = 0;
        System.out.println("Input:    " + left + ", " + right);
        System.out.println("Output:   " + new Solution201().rangeBitwiseAnd(left, right));
        System.out.println("Expected: 0");

        // Example 3
        left = 1;
        right = 2147483647;
        System.out.println("Input:    " + left + ", " + right);
        System.out.println("Output:   " + new Solution201().rangeBitwiseAnd(left, right));
        System.out.println("Expected: 0");
    }
}
