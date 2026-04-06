package org.s3m.leetcode.hard._127;

import org.s3m.leetcode.utils.TreeNode;

import java.util.*;


public class SolutionJava127 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        Queue<String> q = new ArrayDeque<>();
        q.offer(beginWord);
        int ans = 1;
        while (!q.isEmpty()) {
            ++ans;
            for (int i = q.size(); i > 0; --i) {
                String s = q.poll();
                char[] chars = s.toCharArray();
                for (int j = 0; j < chars.length; ++j) {
                    char ch = chars[j];
                    for (char k = 'a'; k <= 'z'; ++k) {
                        chars[j] = k;
                        String t = new String(chars);
                        if (!words.contains(t)) {
                            continue;
                        }
                        if (endWord.equals(t)) {
                            return ans;
                        }
                        q.offer(t);
                        words.remove(t);
                    }
                    chars[j] = ch;
                }
            }
        }
        return 0;
    }


    public static void main(String[] args) {

        // Example 1
        String beginWorld = "hit";
        String endWorld = "cog";
        List<String> wordList = List.of("hot","dot","dog","lot","log","cog");
        System.out.println("Input:    " + beginWorld + ", " + endWorld + ", " + wordList);
        System.out.println("Output:   " + new SolutionJava127().ladderLength(beginWorld, endWorld, wordList));
        System.out.println("Expected: 5");

        // Example 2
        beginWorld = "hit";
        endWorld = "cog";
        wordList = List.of("hot","dot","dog","lot","log");
        System.out.println("Input:    " + beginWorld + ", " + endWorld + ", " + wordList);
        System.out.println("Output:   " + new SolutionJava127().ladderLength(beginWorld, endWorld, wordList));
        System.out.println("Expected: 0");


    }
}
