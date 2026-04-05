package org.s3m.leetcode.medium._5;


import java.util.Arrays;

public class SolutionJava5 {

    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (var g : dp) {
            Arrays.fill(g, true);
        }
        int k = 0, mx = 1;
        for (int i = n - 2; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                dp[i][j] = false;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                    if (dp[i][j] && mx < j - i + 1) {
                        mx = j - i + 1;
                        k = i;
                    }
                }
            }
        }
        return s.substring(k, k + mx);
    }

    public static void main(String[] result) {

        // Example 1
        String s = "babad";
        System.out.println("Input:    " + s);
        System.out.println("Output:   " + new SolutionJava5().longestPalindrome(s));
        System.out.println("Expected: aba");

        // Example 2
        s = "cbbd";
        System.out.println("Input:    " + s);
        System.out.println("Output:   " + new SolutionJava5().longestPalindrome(s));
        System.out.println("Expected: bb");

        // Example 3
        s = "a";
        System.out.println("Input:    " + s);
        System.out.println("Output:   " + new SolutionJava5().longestPalindrome(s));
        System.out.println("Expected: a");
    }
}
