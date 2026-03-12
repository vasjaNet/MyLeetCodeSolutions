package org.s3m.leetcode.medium;

/**
 * Pow(x, n)
 * <p>
 * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
 * <p>
 * Example 1:
 * Input: x = 2.00000, n = 10
 * Output: 1024.00000
 * Example 2:
 * Input: x = 2.10000, n = 3
 * Output: 9.26100
 * Example 3:
 * Input: x = 2.00000, n = -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 */
public class Solution50 {

    public double myPow(double x, int n) {
        if(n == 0) return 1;
        if (x == 1) return 1;
        if (x == -1) return n % 2 == 0 ? 1 : -1;
        if (n == Integer.MIN_VALUE || n == Integer.MAX_VALUE) return 0;
        if (n < 0) {
            return 1 / myPow(x, -n);
        }

        double half = myPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return x * half * half;
        }
    }


    public static void main(String[] args) {
        Solution50 solution = new Solution50();

        // Example 1
        double x1 = 2.00000;
        int n1 = 10;
        System.out.println("Input:    x = " + x1 + ", n = " + n1);
        System.out.println("Output:   " + solution.myPow(x1, n1));
        System.out.println("Expected: 1024.00000");

        // Example 2
        double x2 = 2.10000;
        int n2 = 3;
        System.out.println("\nInput:    x = " + x2 + ", n = " + n2);
        System.out.println("Output:   " + solution.myPow(x2, n2));
        System.out.println("Expected: 9.26100");

        // Example 3
        double x3 = 2.00000;
        int n3 = -2;
        System.out.println("\nInput:    x = " + x3 + ", n = " + n3);
        System.out.println("Output:   " + solution.myPow(x3, n3));
        System.out.println("Expected: 0.25000");

        // Example 4
        double x4 = 2.00000;
        int n4 = -2147483648;
        System.out.println("\nInput:    x = " + x4 + ", n = " + n4);
        System.out.println("Output:   " + solution.myPow(x4, n4));
        System.out.println("Expected: 0.0000");
    }
}
