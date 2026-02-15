package org.s3m.leetcode.easy;


import java.util.Arrays;

/**
 * Plus One
 * <p>
 * You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
 * Increment the large integer by one and return the resulting array of digits.
 * <p>
 * Example 1:
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Incrementing by one gives 123 + 1 = 124.
 * Thus, the result should be [1,2,4].
 * Example 2:
 * Input: digits = [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * Incrementing by one gives 4321 + 1 = 4322.
 * Thus, the result should be [4,3,2,2].
 * Example 3:
 * Input: digits = [9]
 * Output: [1,0]
 * Explanation: The array represents the integer 9.
 * Incrementing by one gives 9 + 1 = 10.
 * Thus, the result should be [1,0].
 */
public class Solution66 {

    public int[] plusOne(int[] digits) {
        int i = digits.length-1;
        int inc = 1;
        do {
            int d = digits[i]+inc;
            if (d > 9) {
                digits[i] = 0;
            } else {
                digits[i] = d;
                inc = 0;
            }
            i--;
        } while (inc == 1 && i >= 0);
        if(inc == 1) {
            int[] newArray = new int[digits.length + 1];
            newArray[0] = 1;
            System.arraycopy(digits, 0, newArray, 1, digits.length);
            return newArray;
        }
        return digits;
    }

    public static void main(String[] args) {
        // Example 1
        int[] digits = {1,2,3};
        System.out.println("Input:    " + Arrays.toString(digits));
        System.out.println("Output:   " + Arrays.toString(new Solution66().plusOne(digits)));
        System.out.println("Expected: [1,2,4]");

        // Example 2
        digits = new int[]{4,3,2,1};
        System.out.println("Input:    " + Arrays.toString(digits));
        System.out.println("Output:   " + Arrays.toString(new Solution66().plusOne(digits)));
        System.out.println("Expected: [4,3,2,2]");

        // Example 3
        digits = new int[]{9};
        System.out.println("Input:    " + Arrays.toString(digits));
        System.out.println("Output:   " + Arrays.toString(new Solution66().plusOne(digits)));
        System.out.println("Expected: [1,0]");

    }
}
