package org.s3m.leetcode.easy;


/**
 * Number of 1 Bits
 * <p>
 * Given a positive integer n, write a function that returns the number of set bits in its binary representation (also known as the Hamming weight).
 * <p>
 * Example 1:
 * Input: n = 11
 * Output: 3
 * Explanation:
 * The input binary string 1011 has a total of three set bits.
 * Example 2:
 * Input: n = 128
 * Output: 1
 * Explanation:
 * The input binary string 10000000 has a total of one set bit.
 * Example 3:
 * Input: n = 2147483645
 * Output: 30
 * Explanation:
 * The input binary string 1111111111111111111111111111101 has a total of thirty set bits.
 */
public class Solution191 {

    public int hammingWeight(int n) {
        int count = 0;
        while(n>0) {
            if(n % 2 == 1) count++;
            n = n >> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        // Example 1
        int n = 11;
        System.out.println("Input:    " + n);
        System.out.println("Output:   " + new Solution191().hammingWeight(n));
        System.out.println("Expected: 3");

        // Example 2
        n = 128;
        System.out.println("Input:    " + n);
        System.out.println("Output:   " + new Solution191().hammingWeight(n));
        System.out.println("Expected: 1");

        // Example 3
        n = 2147483645;
        System.out.println("Input:    " + n);
        System.out.println("Output:   " + new Solution191().hammingWeight(n));
        System.out.println("Expected: 30");
    }
}
