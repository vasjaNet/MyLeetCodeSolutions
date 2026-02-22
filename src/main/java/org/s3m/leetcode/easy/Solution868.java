package org.s3m.leetcode.easy;


/**
 * Binary Gap
 * <p>
 * Given a positive integer n, find and return the longest distance between any two adjacent 1's in the binary representation of n. If there are no two adjacent 1's, return 0.
 * Two 1's are adjacent if there are only 0's separating them (possibly no 0's). The distance between two 1's is the absolute difference between their bit positions. For example, the two 1's in "1001" have a distance of 3.
 * <p>
 * Example 1:
 * Input: n = 22
 * Output: 2
 * Explanation: 22 in binary is "10110".
 * The first adjacent pair of 1's is "10110" with a distance of 2.
 * The second adjacent pair of 1's is "10110" with a distance of 1.
 * The answer is the largest of these two distances, which is 2.
 * Note that "10110" is not a valid pair since there is a 1 separating the two 1's underlined.
 * Example 2:
 * Input: n = 8
 * Output: 0
 * Explanation: 8 in binary is "1000".
 * There are not any adjacent pairs of 1's in the binary representation of 8, so we return 0.
 * Example 3:
 * Input: n = 5
 * Output: 2
 * Explanation: 5 in binary is "101".
 */
public class Solution868 {

    public int hammingWeight(int n) {
        int count = 0;
        while(n>0) {
            if(n % 2 == 1) count++;
            n = n >> 1;
        }
        return count;
    }

    public int binaryGap(int n) {
        int max = 0;
        int start = 0;
        int count = 0;
        int onesCounts = 0;
        while(n > 0) {
            if (n % 2 == 1) {
                onesCounts++;
                start = count;
            } else {
                if(onesCounts > 0) {
                    max = Math.max(max, count - start + 1);
                }
            }
            count++;
            n = n >> 1;
        }
        if(onesCounts > 1) {
            max = Math.max(max, count - start);
        }
        return max;
    }

    public static void main(String[] args) {


        // Example 1
        int n = 22;
        System.out.println("Input:    " + n);
        System.out.println("Output:   " + new Solution868().binaryGap(n));
        System.out.println("Expected: 2");

        // Example 2
        n = 8;
        System.out.println("Input:    " + n);
        System.out.println("Output:   " + new Solution868().binaryGap(n));
        System.out.println("Expected: 0");

        // Example 3
        n = 5;
        System.out.println("Input:    " + n);
        System.out.println("Output:   " + new Solution868().binaryGap(n));
        System.out.println("Expected: 2");

        // Example 4
        n = 6;
        System.out.println("Input:    " + n);
        System.out.println("Output:   " + new Solution868().binaryGap(n));
        System.out.println("Expected: 1");

    }
}
