package org.s3m.leetcode.medium;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Word Break
 * <p>
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 * <p>
 * Example 1:
 * Input: s = "leetcode", wordDict = ["leet","code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * Example 2:
 * Input: s = "applepenapple", wordDict = ["apple","pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 * Note that you are allowed to reuse a dictionary word.
 * Example 3:
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * Output: false
 */
public class Solution139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Set<String> set = new HashSet<>(wordDict);
        int[] dp = new int[n+1];
        dp[0] = 1;
        int minLength = n;
        int maxLength = 0;
        for(String word: wordDict) {
            minLength = Math.min(minLength, word.length());
            maxLength = Math.max(maxLength, word.length());
        }
        int start = 0;
        for(int i = minLength; i <= n; i++) {
            start = Math.max(start, i-maxLength);
            for(int j = start; j < i; j++) {
                if(dp[j] == 1 && set.contains(s.substring(j, i))) {
                    dp[i] = 1;
                    break;
                }
            }
        }
        return dp[n] == 1;
    }



    public static void main(String[] args) {

        // Example 1
        String s = "leetcode";
        List<String> wordDict = List.of("leet","code");
        System.out.println("Input:    " + s + ", " + wordDict);
        System.out.println("Output:   " + new Solution139().wordBreak(s, wordDict));
        System.out.println("Expected: true");

        // Example 2
        s = "applepenapple";
        wordDict = List.of("apple","pen");
        System.out.println("Input:    " + s + ", " + wordDict);
        System.out.println("Output:   " + new Solution139().wordBreak(s, wordDict));
        System.out.println("Expected: true");

        // Example 3
        s = "catsandog";
        wordDict = List.of("cats","dog","sand","and","cat");
        System.out.println("Input:    " + s + ", " + wordDict);
        System.out.println("Output:   " + new Solution139().wordBreak(s, wordDict));
        System.out.println("Expected: false");


    }
}
