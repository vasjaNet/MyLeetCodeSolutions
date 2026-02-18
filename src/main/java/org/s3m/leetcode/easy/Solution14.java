package org.s3m.leetcode.easy;


/**
 * Longest Common Prefix
 * <p>
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 * <p>
 * Example 1:
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 */
public class Solution14 {

    public String longestCommonPrefix(String[] strs) {
        if(strs.length <= 1) {
            return strs.length == 1 ? strs[0] : "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < prefix.length()) {
                prefix = prefix.substring(0, strs[i].length());
            }
            while(!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        // Example 1
        String[] strs = {"flower","flow","flight"};
        System.out.println("Input:    " + String.join(", ", strs));
        System.out.println("Output:   " + new Solution14().longestCommonPrefix(strs));
        System.out.println("Expected: fl");

        // Example 2
        strs = new String[]{"dog","racecar","car"};
        System.out.println("Input:    " + String.join(", ", strs));
        System.out.println("Output:   " + new Solution14().longestCommonPrefix(strs));
        System.out.println("Expected: ");

    }
}
