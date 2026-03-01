package org.s3m.leetcode.easy;


import java.util.*;

/**
 * Valid Anagram
 * <p>
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * <p>
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false
 */
public class Solution242 {

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] letters = new int[26];
        for(char c : s.toCharArray()) {
            ++letters[c - 'a'];
        }
        for(char c : t.toCharArray()) {
            if(letters[c - 'a'] == 0) return false;
            --letters[c - 'a'];
        }
        for( int entry : letters) {
            if(entry != 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {

        // Example 1
        String s1 = "anagram";
        String t1 = "nagaram";
        Solution242 solution = new Solution242();
        boolean result1 = solution.isAnagram(s1, t1);
        System.out.println("Example 1 Output: " + result1);
        System.out.println("Expected: true");

        // Example 2
        String s2 = "rat";
        String t2 = "car";
        boolean result2 = solution.isAnagram(s2, t2);
        System.out.println("Example 2 Output: " + result2);
        System.out.println("Expected: false");

    }
}
