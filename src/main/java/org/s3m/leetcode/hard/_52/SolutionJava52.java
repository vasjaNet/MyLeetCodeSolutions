package org.s3m.leetcode.hard._52;


public class SolutionJava52 {

    private int n;
    private int ans;
    private final boolean[] cols = new boolean[10];
    private final boolean[] dg = new boolean[20];
    private final boolean[] udg = new boolean[20];

    public int totalNQueens(int n) {
        this.n = n;
        dfs(0);
        return ans;
    }

    private void dfs(int i) {
        if (i == n) {
            ++ans;
            return;
        }
        for (int j = 0; j < n; ++j) {
            int a = i + j, b = i - j + n;
            if (cols[j] || dg[a] || udg[b]) {
                continue;
            }
            cols[j] = true;
            dg[a] = true;
            udg[b] = true;
            dfs(i + 1);
            cols[j] = false;
            dg[a] = false;
            udg[b] = false;
        }
    }

    public static void main(String[] args) {

        // Example 1
        int n = 4;
        System.out.println("Input:    " + n);
        System.out.println("Output:   " + new SolutionJava52().totalNQueens(n));
        System.out.println("Expected: 2");

        // Example 2
        n = 1;
        System.out.println("Input:    " + n);
        System.out.println("Output:   " + new SolutionJava52().totalNQueens(n));
        System.out.println("Expected: 1");

        // Example 3
        n = 8;
        System.out.println("Input:    " + n);
        System.out.println("Output:   " + new SolutionJava52().totalNQueens(n));
        System.out.println("Expected: 92");



    }

}
