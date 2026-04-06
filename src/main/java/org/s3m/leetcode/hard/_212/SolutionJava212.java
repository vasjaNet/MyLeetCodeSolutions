package org.s3m.leetcode.hard._212;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionJava212 {
    static class Trie {
        Trie[] children = new Trie[26];
        int ref = -1;

        public void insert(String w, int ref) {
            Trie node = this;
            for (int i = 0; i < w.length(); ++i) {
                int j = w.charAt(i) - 'a';
                if (node.children[j] == null) {
                    node.children[j] = new Trie();
                }
                node = node.children[j];
            }
            node.ref = ref;
        }
    }

    private char[][] board;
    private String[] words;
    private List<String> ans = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        this.words = words;
        Trie tree = new Trie();
        for (int i = 0; i < words.length; ++i) {
            tree.insert(words[i], i);
        }
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                dfs(tree, i, j);
            }
        }
        return ans;
    }

    private void dfs(Trie node, int i, int j) {
        int idx = board[i][j] - 'a';
        if (node.children[idx] == null) {
            return;
        }
        node = node.children[idx];
        if (node.ref != -1) {
            ans.add(words[node.ref]);
            node.ref = -1;
        }
        char c = board[i][j];
        board[i][j] = '#';
        int[] dirs = {-1, 0, 1, 0, -1};
        for (int k = 0; k < 4; ++k) {
            int x = i + dirs[k], y = j + dirs[k + 1];
            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] != '#') {
                dfs(node, x, y);
            }
        }
        board[i][j] = c;
    }

    public static void main(String[] args) {

        // Example 1
        char[][] board = {
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };
        String[] words = {"oath","pea","eat","rain"};
        System.out.println("Input:    " + board + ", " + Arrays.toString(words));
        System.out.println("Output:   " + new SolutionJava212().findWords(board, words));
        System.out.println("Expected: [eat,oath]");

        // Example 2
        board = new char[][]{
                {'a','b'},
                {'c','b'}
        };
        words = new String[]{"abcb"};
        System.out.println("Input:    " + board + ", " + Arrays.toString(words));
        System.out.println("Output:   " + new SolutionJava212().findWords(board, words));
        System.out.println("Expected: []");

    }
}
