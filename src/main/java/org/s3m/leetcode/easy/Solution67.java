package org.s3m.leetcode.easy;



/**
 * Add Binary
 * <p>
 * Given two binary strings a and b, return their sum as a binary string.
 * <p>
 * Example 1:
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 */
public class Solution67 {

    public String addBinary(String a, String b) {
        int an = a.length();
        int bn = b.length();
        char[] acc = an > bn ? a.toCharArray() : b.toCharArray();
        String op =  an > bn ? b : a;
        int c = 0;
        int j = op.length()-1;
        for( int i = acc.length-1; i >= 0; i--) {
            int s1 = acc[i] - '0';
            int s2 = 0;
            if(j >= 0) {
                s2 += op.charAt(j--) - '0';
            }

            int sum = s1+s2+c;
            if(sum == 0) {
                acc[i] = '0';
                c = 0;
            } else if(sum == 1) {
                acc[i] = '1';
                c=0;
            } else if (sum == 2) {
                acc[i] = '0';
                c=1;
            } else if (sum == 3) {
                acc[i] = '1';
                c=1;
            }
        }
        if(c == 1) {
            char[] newAcc = new char[acc.length+1];
            newAcc[0] = '1';
            System.arraycopy(acc, 0, newAcc, 1, acc.length);
            acc = newAcc;
        }
        return new String(acc);
    }

    public static void main(String[] args) {
        // Example 1
        String a = "11";
        String b = "1";
        System.out.println("Input:    a = " + a + ", b = " + b);
        System.out.println("Output:   " + new Solution67().addBinary(a, b));
        System.out.println("Expected: 100");

        // Example 2
        a = "1010";
        b = "1011";
        System.out.println("Input:    a = " + a + ", b = " + b);
        System.out.println("Output:   " + new Solution67().addBinary(a, b));
        System.out.println("Expected: 10101");

    }
}
