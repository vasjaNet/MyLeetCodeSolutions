package org.s3m.leetcode.medium._139;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionJava139 {

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
        System.out.println("Output:   " + new SolutionJava139().wordBreak(s, wordDict));
        System.out.println("Expected: true");

        // Example 2
        s = "applepenapple";
        wordDict = List.of("apple","pen");
        System.out.println("Input:    " + s + ", " + wordDict);
        System.out.println("Output:   " + new SolutionJava139().wordBreak(s, wordDict));
        System.out.println("Expected: true");

        // Example 3
        s = "catsandog";
        wordDict = List.of("cats","dog","sand","and","cat");
        System.out.println("Input:    " + s + ", " + wordDict);
        System.out.println("Output:   " + new SolutionJava139().wordBreak(s, wordDict));
        System.out.println("Expected: false");


    }
}
