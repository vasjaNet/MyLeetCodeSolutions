package org.s3m.leetcode.medium._130;


import java.util.*;

public class SolutionJava130 {
    record IntPair(int a, int b) {}
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        Set<IntPair> set = new HashSet<>();
        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1) {
                    if (board[i][j] == 'O') {
                        set.add(new IntPair(i, j));
                        dfs(board, set, i, j);
                    }
                } else {
                    if ((j == 0 || j == n - 1) && board[i][j] == 'O') {
                        set.add(new IntPair(i, j));
                        dfs(board, set, i, j);
                    }
                }
                board[i][j] = 'X';
            }
        }
        for(int i = 1; i < m-1; i++) {
            for(int j = 1; j < n-1; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

        for(IntPair pair : set) {
            board[pair.a][pair.b] = 'O';
        }
    }

    private void dfs(char[][] board, Set<IntPair> set, int i, int j) {
        int i0 = i - 1;
        if(i0 >= 0 && board[i0][j] == 'O') {
            board[i0][j] = 'X';
            set.add(new IntPair(i0,j));
            dfs(board, set, i0, j);
        }
        int i1 = i + 1;
        if(i1 < board.length && board[i1][j] == 'O') {
            board[i1][j] = 'X';
            set.add(new IntPair(i1,j));
            dfs(board, set, i1, j);
        }
        int j0 = j - 1;
        if(j0 >= 0 && board[i][j0] == 'O') {
            board[i][j-1] = 'X';
            set.add(new IntPair(i,j0));
            dfs(board, set, i, j0);
        }
        int j1 = j + 1;
        if(j1 < board[0].length && board[i][j1] == 'O') {
            board[i][j1] = 'X';
            set.add(new IntPair(i,j1));
            dfs(board, set, i, j1);
        }

    }



    public static void main(String[] args) {

        // Example 1
        char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        SolutionJava130 solution = new SolutionJava130();
        solution.solve(board);
        System.out.println("Output:   " + Arrays.toString(board));

        //Example 2
        board = new char[][]{{'X'}};
        solution.solve(board);
        System.out.println("Output:   " + Arrays.toString(board));

    }
}
