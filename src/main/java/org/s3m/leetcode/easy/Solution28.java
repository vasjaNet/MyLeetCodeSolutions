package org.s3m.leetcode.easy;



/**
 * Find the Index of the First Occurrence in a String
 * <p>
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * <p>
 * Example 1:
 * Input: haystack = "sadbutsad", needle = "sad"
 * Output: 0
 * Explanation: "sad" occurs at index 0 and 6.
 * The first occurrence is at index 0, so we return 0.
 * Example 2:
 * Input: haystack = "leetcode", needle = "leeto"
 * Output: -1
 * Explanation: "leeto" did not occur in "leetcode", so we return -1.
 * Example 3:
 * Input: haystack = "a", needle = "a"
 * Output: -1
 * Explanation: "leeto" did not occur in "leetcode", so we return -1.
 */
public class Solution28 {

    public int strStr(String haystack, String needle) {
        if(haystack.length() < needle.length()) return -1;
        boolean equals;
        int i = 0;
        do{
            equals = true;
            for(int j=0; j < needle.length(); j++) {
                if(haystack.charAt(i+j) != needle.charAt(j)) {
                    equals = false;
                    break;
                }
            }
            if(equals) return i;
            i++;
        } while(i <= haystack.length()-needle.length());
        return -1;
    }

    public static void main(String[] args) {
        // Example 1
        String haystack = "sadbutsad";
        String needle = "sad";
        System.out.println("Input:    " + haystack + ", " + needle);
        System.out.println("Output:   " + new Solution28().strStr(haystack, needle));
        System.out.println("Expected: 0");

        // Example 2
        haystack = "leetcode";
        needle = "leeto";
        System.out.println("Input:    " + haystack + ", " + needle);
        System.out.println("Output:   " + new Solution28().strStr(haystack, needle));
        System.out.println("Expected: -1");

        // Example 3
        haystack = "a";
        needle = "a";
        System.out.println("Input:    " + haystack + ", " + needle);
        System.out.println("Output:   " + new Solution28().strStr(haystack, needle));
        System.out.println("Expected: 0");

        // Example 3
        haystack = "abc";
        needle = "c";
        System.out.println("Input:    " + haystack + ", " + needle);
        System.out.println("Output:   " + new Solution28().strStr(haystack, needle));
        System.out.println("Expected: 2");

    }
}
