package org.s3m.leetcode.easy;

/**
 * Palindrome Number
 * <p>
 * Given an integer x, return true if x is a palindrome, and false otherwise.
 * <p>
 * Example 1:
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 * Example 2:
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 */
public class Solution9 {

    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        String original = String.valueOf(x);
        String revers = new StringBuilder(String.valueOf(x)).reverse().toString();
        return original.equals(revers);
    }

    public static void main(String[] args) {
        // Example 1
        int x = 121;
        System.out.println("Input:    " + x);
        System.out.println("Output:   " + new Solution9().isPalindrome(x));
        System.out.println("Expected: true");

        // Example 2
        x = -121;
        System.out.println("Input:    " + x);
        System.out.println("Output:   " + new Solution9().isPalindrome(x));
        System.out.println("Expected: false");

        // Example 3
        x = 10;
        System.out.println("Input:    " + x);
        System.out.println("Output:   " + new Solution9().isPalindrome(x));
        System.out.println("Expected: false");
    }


}
