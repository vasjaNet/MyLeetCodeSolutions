package org.s3m.leetcode.medium._49;


import java.util.*;

public class SolutionJava49 {

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
        System.out.println("Output:   " + new SolutionJava49().groupAnagrams(strs));
        System.out.println("Expected: [[bat], [nat, tan], [ate, eat, tea]]");

        // Example 2
        strs = new String[]{""};
        System.out.println("Input:    " + String.join(", ", strs));
        System.out.println("Output:   " + new SolutionJava49().groupAnagrams(strs));
        System.out.println("Expected: [[\"\" ]]");

        // Example 3
        strs = new String[]{"a"};
        System.out.println("Input:    " + String.join(", ", strs));
        System.out.println("Output:   " + new SolutionJava49().groupAnagrams(strs));
        System.out.println("Expected: [[\"a\" ]]");

    }
}
