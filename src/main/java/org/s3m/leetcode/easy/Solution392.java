package org.s3m.leetcode.easy;



/**
 * Is Subsequence
 * <p>
 * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 * <p>
 * Example 1:
 * Input: s = "abc", t = "ahbgdc"
 * Output: true
 * Example 2:
 * Input: s = "axc", t = "ahbgdc"
 * Output: false
 */
public class Solution392 {

    public boolean isSubsequence(String s, String t) {
        int tn = t.length();
        int sn = s.length();
        if(tn < sn) return false;
        if(sn ==0) return true;
        int si = 0;
        for(int i = 0; i < tn; i++) {
            if(t.charAt(i) == s.charAt(si)) {
                si++;
            }
            if(si == sn) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Example 1
        String s = "abc";
        String t = "ahbgdc";
        System.out.println("Input:    " + s + ", " + t);
        System.out.println("Output:   " + new Solution392().isSubsequence(s, t));
        System.out.println("Expected: true");

        // Example 2
        s = "axc";
        t = "ahbgdc";
        System.out.println("Input:    " + s + ", " + t);
        System.out.println("Output:   " + new Solution392().isSubsequence(s, t));
        System.out.println("Expected: false");

        // Example 2
        s = "b";
        t = "c";
        System.out.println("Input:    " + s + ", " + t);
        System.out.println("Output:   " + new Solution392().isSubsequence(s, t));
        System.out.println("Expected: false");

    }
}
