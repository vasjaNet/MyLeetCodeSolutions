package org.s3m.leetcode.easy;



/**
 * Sqrt(x)
 * <p>
 * Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.
 * You must not use any built-in exponent function or operator.
 * For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
 * <p>
 * Example 1:
 * Input: x = 4
 * Output: 2
 * Explanation: The square root of 4 is 2, so we return 2.
 * Example 2:
 * Input: x = 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
 */
public class Solution69 {

    //todo: use binary search
    public int mySqrt(int x) {
        long sqrt = 0;
        int res = 0;
        if(x > 100) res = 10;
        if(x > 10000) res = 100;
        if(x > 1000000) res = 1000;
        if(x > 100000000) res = 10000;
        if(x > 400000000) res = 20000;
        if(x > 900000000) res = 30000;
        if(x > 2025000000) res = 45000;
        while (sqrt <= x) {
            res++;
            sqrt = (long)res * (long)res;

        }
        return res-1;
    }

    public static void main(String[] args) {
        // Example 1
        int x = 4;
        System.out.println("Input:    " + x);
        System.out.println("Output:   " + new Solution69().mySqrt(x));
        System.out.println("Expected: 2");

        // Example 2
        x = 8;
        System.out.println("Input:    " + x);
        System.out.println("Output:   " + new Solution69().mySqrt(x));
        System.out.println("Expected: 2");
    }
}
