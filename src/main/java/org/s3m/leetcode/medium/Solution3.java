package org.s3m.leetcode.medium;


import java.util.HashSet;
import java.util.Set;

/**
 * Longest Substring Without Repeating Characters
 * <p>
 * Given a string s, find the length of the longest substring without duplicate characters.
 * <p>
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
 * Example 2:
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class Solution3 {

    public static int lengthOfLongestSubstring(String s) {
        int slov = 0;
        int f = 0;
        int maxLength = 0;
        char[] a = s.toCharArray();
        Set<Character> set = new HashSet<>();
        while(f < a.length) {
            char lastChar = a[f];
            if(set.contains(lastChar)) {
                set.remove(a[slov++]);
            } else {
                set.add(lastChar);
                int length = f-slov+1;
                if (maxLength < length) {
                    maxLength = length;
                }
                f++;
            }
        }
        return maxLength;

    }

    public static void main(String[] args) {
        // Example 1
        String s = "abcabcbb";
        System.out.println("Input:    " + s);
        System.out.println("Output:   " + lengthOfLongestSubstring(s));
        System.out.println("Expected: 3");

        // Example 2
        s = "bbbbb";
        System.out.println("Input:    " + s);
        System.out.println("Output:   " + lengthOfLongestSubstring(s));
        System.out.println("Expected: 1");

        // Example 3
        s = "pwwkew";
        System.out.println("Input:    " + s);
        System.out.println("Output:   " + lengthOfLongestSubstring(s));
        System.out.println("Expected: 3");

    }
}
