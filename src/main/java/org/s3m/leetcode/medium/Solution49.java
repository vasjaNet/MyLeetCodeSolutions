package org.s3m.leetcode.medium;


import java.util.*;

/**
 * Group Anagrams
 * <p>
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 * <p>
 * Example 1:
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * Explanation:
 * There is no string in strs that can be rearranged to form "bat".
 * The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
 * The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
 * Example 2:
 * Input: strs = [""]
 * Output: [[""]]
 * Example 3:
 * Input: strs = ["a"]
 * Output: [["a"]]
 */
public class Solution49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            List<String> anagram = anagrams.getOrDefault(sortedStr, new ArrayList<>());
            anagram.add(str);
            anagrams.put(sortedStr, anagram);
        }
        return new ArrayList<>(anagrams.values());
    }

    public static void main(String[] args) {

        // Example 1
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println("Input:    " + String.join(", ", strs));
        System.out.println("Output:   " + new Solution49().groupAnagrams(strs));
        System.out.println("Expected: [[bat], [nat, tan], [ate, eat, tea]]");

        // Example 2
        strs = new String[]{""};
        System.out.println("Input:    " + String.join(", ", strs));
        System.out.println("Output:   " + new Solution49().groupAnagrams(strs));
        System.out.println("Expected: [[\"\" ]]");

        // Example 3
        strs = new String[]{"a"};
        System.out.println("Input:    " + String.join(", ", strs));
        System.out.println("Output:   " + new Solution49().groupAnagrams(strs));
        System.out.println("Expected: [[\"a\" ]]");

    }
}
