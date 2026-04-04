package org.s3m.leetcode.medium._79;


public class SolutionJava79 {
    private int m;
    private int n;
    private char[] wordChar;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        this.wordChar = word.toCharArray();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (dfs(board, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board,int i, int j, int k) {
        if (k == wordChar.length) {
            return true;
        }
        if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] !=  wordChar[k]) {
            return false;
        }
        char tmp = board[i][j];
        board[i][j] = '0';
        boolean found = dfs(board, i+1, j, k + 1) ||
                dfs(board, i-1, j, k + 1) ||
                dfs(board, i, j+1, k + 1) ||
                dfs(board, i, j-1, k + 1);
        board[i][j] = tmp;
        return found;
    }

    public static void main(String[] args) {

        // Example 1
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        String word = "ABCCED";
        System.out.println("Input:    " + board + ", " + word);
        System.out.println("Output:   " + new SolutionJava79().exist(board, word));
        System.out.println("Expected: true");

        // Example 2
        board = new char[][] {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        word = "SEE";
        System.out.println("Input:    " + board + ", " + word);
        System.out.println("Output:   " + new SolutionJava79().exist(board, word));
        System.out.println("Expected: true");

        // Example 3
        board = new char[][] {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        word = "ABCB";
        System.out.println("Input:    " + board + ", " + word);
        System.out.println("Output:   " + new SolutionJava79().exist(board, word));
        System.out.println("Expected: false");

    }
}
