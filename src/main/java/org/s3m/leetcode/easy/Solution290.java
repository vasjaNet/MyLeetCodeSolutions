package org.s3m.leetcode.easy;


import java.util.HashMap;
import java.util.Map;

/**
 * Word Pattern
 * <p>
 * Given a pattern and a string s, find if s follows the same pattern.
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s. Specifically:
 * Each letter in pattern maps to exactly one unique word in s.
 * Each unique word in s maps to exactly one letter in pattern.
 * No two letters map to the same word, and no two words map to the same letter.
 * <p>
 * Example 1:
 * Input: pattern = "abba", s = "dog cat cat dog"
 * Output: true
 * Explanation:
 * The bijection can be established as:
 * 'a' maps to "dog".
 * 'b' maps to "cat".
 * Example 2:
 * Input: pattern = "abba", s = "dog cat cat fish"
 * Output: false
 * Example 3:
 * Input: pattern = "aaaa", s = "dog cat cat dog"
 * Output: false
 */
public class Solution290 {


    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if(words.length != pattern.length()) return false;
        Map<Character, String> map = new HashMap<>();
        for(int i = 0; i < words.length; i++) {
            String word = words[i];
            char c = pattern.charAt(i);
            if(map.containsKey(c) && !map.get(c).equals(word)) {
                return false;
            }
            if(!map.containsKey(c) && map.containsValue(word)) {
                return false;
            }
            map.put(c, word);
        }
        return true;
    }




    public static void main(String[] args) {
        // Example 1
        String pattern = "abba", s = "dog cat cat dog";
        System.out.println("Input:    " + pattern + ", " + s);
        System.out.println("Output:   " + new Solution290().wordPattern(pattern, s));
        System.out.println("Expected: true");

        // Example 2
        pattern = "abba"; s = "dog cat cat fish";
        System.out.println("Input:    " + pattern + ", " + s);
        System.out.println("Output:   " + new Solution290().wordPattern(pattern, s));
        System.out.println("Expected: false");

        // Example 3
        pattern = "aaaa"; s = "dog cat cat dog";
        System.out.println("Input:    " + pattern + ", " + s);
        System.out.println("Output:   " + new Solution290().wordPattern(pattern, s));
        System.out.println("Expected: false");
    }
}
