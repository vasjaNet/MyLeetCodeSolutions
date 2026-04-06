package org.s3m.leetcode.medium._97;


public class SolutionJava97 {

    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        if (m + n != s3.length()) {
            return false;
        }
        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        char[] chars3 = s3.toCharArray();
        for (int i = 0; i <= m; ++i) {
            for (int j = 0; j <= n; ++j) {
                int k = i + j - 1;
                if (i > 0 && chars1[i - 1] == chars3[k]) {
                    f[i][j] = f[i - 1][j];
                }
                if (j > 0 && chars2[j - 1] == chars3[k]) {
                    f[i][j] |= f[i][j - 1];
                }
            }
        }
        return f[m][n];
    }

    public static void main(String[] args) {

        // Example 1
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        System.out.println("Input:    " + s1 + ", " + s2 + ", " + s3);
        System.out.println("Output:   " + new SolutionJava97().isInterleave(s1, s2, s3));
        System.out.println("Expected: true");

        // Example 2
        s1 = "aabcc"; s2 = "dbbca"; s3 = "aadbbbaccc";
        System.out.println("Input:    " + s1 + ", " + s2 + ", " + s3);
        System.out.println("Output:   " + new SolutionJava97().isInterleave(s1, s2, s3));
        System.out.println("Expected: false");

        // Example 3
        s1 = ""; s2 = ""; s3 = "";
        System.out.println("Input:    " + s1 + ", " + s2 + ", " + s3);
        System.out.println("Output:   " + new SolutionJava97().isInterleave(s1, s2, s3));
        System.out.println("Expected: true");


    }
}
