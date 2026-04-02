package org.s3m.leetcode.hard._30;


import java.util.*;

public class SolutionJava30 {

    //todo: use sliding window
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> need = new HashMap<>();
        for (String w : words) {
            need.merge(w, 1, Integer::sum);
        }

        int n = s.length();
        int wordCount = words.length;
        int wordLen = words[0].length();

        for (int offset = 0; offset < wordLen; offset++) {
            int left = offset;
            int count = 0;
            Map<String, Integer> have = new HashMap<>();

            for (int j = offset; j + wordLen <= n; j += wordLen) {
                String word = s.substring(j, j + wordLen);

                if (!need.containsKey(word)) {
                    have.clear();
                    count = 0;
                    left = j + wordLen;
                    continue;
                }

                have.merge(word, 1, Integer::sum);
                count++;

                while (have.get(word) > need.get(word)) {
                    String leftWord = s.substring(left, left + wordLen);
                    have.put(leftWord, have.get(leftWord) - 1);
                    left += wordLen;
                    count--;
                }

                if (count == wordCount) {
                    result.add(left);
                    String leftWord = s.substring(left, left + wordLen);
                    have.put(leftWord, have.get(leftWord) - 1);
                    left += wordLen;
                    count--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

        // Example 1
        String s1 = "barfoothefoobarman";
        String[] words1 = {"foo", "bar"};
        SolutionJava30 solution = new SolutionJava30();
        List<Integer> result1 = solution.findSubstring(s1, words1);
        System.out.println("Example 1 Output: " + result1);
        System.out.println("Expected: [0,9]");

        // Example 2
        String s2 = "wordgoodgoodgoodbestword";
        String[] words2 = {"word", "good", "best", "word"};
        List<Integer> result2 = solution.findSubstring(s2, words2);
        System.out.println("Example 2 Output: " + result2);
        System.out.println("Expected: []");

        // Example 3
        String s3 = "barfoofoobarthefoobarman";
        String[] words3 = {"bar", "foo", "the"};
        List<Integer> result3 = solution.findSubstring(s3, words3);
        System.out.println("Example 3 Output: " + result3);
        System.out.println("Expected: [6,9,12]");

        // Example 4
        String s4 = "wordgoodgoodgoodbestword";
        String[] words4 = {"word","good","best","good"};
        List<Integer> result4 = solution.findSubstring(s4, words4);
        System.out.println("Example 4 Output: " + result4);
        System.out.println("Expected: [8]");

        // Example 5
        String s5 = "ababababab";
        String[] words5 = {"ababa","babab"};
        List<Integer> result5 = solution.findSubstring(s5, words5);
        System.out.println("Example 5 Output: " + result5);
        System.out.println("Expected: [0]");

        // Example 6
        String s6 = "ababaab";
        String[] words6 = {"ab","ba","ba"};
        List<Integer> result6 = solution.findSubstring(s6, words6);
        System.out.println("Example 6 Output: " + result6);
        System.out.println("Expected: [1]");


    }

}
