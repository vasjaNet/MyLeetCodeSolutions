package org.s3m.leetcode.medium;


import java.util.HashMap;
import java.util.Map;

/**
 * Isomorphic Strings
 * <p>
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
 * <p>
 * Example 1:
 * Input: s = "egg", t = "add"
 * Output: true
 * Explanation:
 * The strings s and t can be made identical by:
 * Mapping 'e' to 'a'.
 * Mapping 'g' to 'd'.
 * Example 2:
 * Input: s = "f11", t = "b23"
 * Output: false
 * Explanation:
 * The strings s and t can not be made identical as '1' needs to be mapped to both '2' and '3'.
 * Example 3:
 * Input: s = "paper", t = "title"
 * Output: true
 */
public class Solution205 {

    //todo: optimize by using array instead of map
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> mapping = new HashMap<>();
        Map<Character, Character> reversMapping = new HashMap<>();
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        for(int i = 0; i < s.length(); i++) {
            char sChar = sCharArray[i];
            char tChar = tCharArray[i];
            if(mapping.getOrDefault(sChar, tChar) == tChar && reversMapping.getOrDefault(tChar, sChar) == sChar) {
                mapping.put(sChar, tChar);
                reversMapping.put(tChar, sChar);
            } else  {

                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        // Example 1
        String s = "egg", t = "add";
        System.out.println("Input:    s = " + s + ", t = " + t);
        System.out.println("Output:   " + new Solution205().isIsomorphic(s, t));
        System.out.println("Expected: true");

        // Example 2
        s = "f11"; t = "b23";
        System.out.println("Input:    s = " + s + ", t = " + t);
        System.out.println("Output:   " + new Solution205().isIsomorphic(s, t));
        System.out.println("Expected: false");

        // Example 3
        s = "paper"; t = "title";
        System.out.println("Input:    s = " + s + ", t = " + t);
        System.out.println("Output:   " + new Solution205().isIsomorphic(s, t));
        System.out.println("Expected: true");

        // Example 4
        s = "badc"; t = "baba";
        System.out.println("Input:    s = " + s + ", t = " + t);
        System.out.println("Output:   " + new Solution205().isIsomorphic(s, t));
        System.out.println("Expected: false");
    }
}
