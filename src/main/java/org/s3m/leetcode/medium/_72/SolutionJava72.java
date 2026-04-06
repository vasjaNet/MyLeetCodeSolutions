package org.s3m.leetcode.medium._72;



public class SolutionJava72 {

    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        char[] c1 = word1.toCharArray(), c2 = word2.toCharArray();
        int[][] f = new int[m + 1][n + 1];
        for (int j = 1; j <= n; ++j) {
            f[0][j] = j;
        }
        for (int i = 1; i <= m; ++i) {
            f[i][0] = i;
            for (int j = 1; j <= n; ++j) {
                if (c1[i - 1] == c2[j - 1]) {
                    f[i][j] = f[i - 1][j - 1];
                } else {
                    f[i][j] = Math.min(f[i - 1][j], Math.min(f[i][j - 1], f[i - 1][j - 1])) + 1;
                }
            }
        }
        return f[m][n];
    }

    public static void main(String[] args) {
        // Example 1
        String word1 = "horse", word2 = "ros";
        System.out.println("Input:    " + word1 + ", " + word2);
        System.out.println("Output:   " + new SolutionJava72().minDistance(word1, word2));
        System.out.println("Expected: 3");

        // Example 2
        word1 = "intention";
        word2 = "execution";
        System.out.println("Input:    " + word1 + ", " + word2);
        System.out.println("Output:   " + new SolutionJava72().minDistance(word1, word2));
        System.out.println("Expected: 5");

        // Example 3
        word1 = "a";
        word2 = "a";
        System.out.println("Input:    " + word1 + ", " + word2);
        System.out.println("Output:   " + new SolutionJava72().minDistance(word1, word2));
        System.out.println("Expected: 0");

    }
}
