package org.s3m.leetcode.easy;


/**
 * Reverse Bits
 * <p>
 * Reverse bits of a given 32 bits signed integer.
 * <p>
 * Example 1:
 * Input: n = 43261596
 * Output: 964176192
 * Explanation:
 * Integer	Binary
 * 43261596	00000010100101000001111010011100
 * 964176192	00111001011110000010100101000000
 * Example 2:
 * Input: n = 2147483644
 * Output: 1073741822
 * Explanation:
 * Integer	Binary
 * 2147483644	01111111111111111111111111111100
 * 1073741822	00111111111111111111111111111110.
 */
public class Solution190 {

    public int reverseBits(int n) {
        int[] bin = new int[32];
        int i = 0;
        while(n>0) {
            bin[i++] = n % 2;
            n = n / 2;
        }
        int rez=0;
        for(int j = 0; j < 32; j++) {
            rez*=2;
            rez+=bin[j];
        }
        return rez;
    }

    public static void main(String[] args) {
        // Example 1
        int n = 43261596;
        System.out.println("Input:    " + n);
        System.out.println("Output:   " + new Solution190().reverseBits(n));
        System.out.println("Expected: 964176192");

        // Example 2
        n = 2147483644;
        System.out.println("Input:    " + n);
        System.out.println("Output:   " + new Solution190().reverseBits(n));
        System.out.println("Expected: 1073741822");
    }
}
