package org.s3m.leetcode.medium;


/**
 * Ransom Note
 * <p>
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
 * Each letter in magazine can only be used once in ransomNote.
 * <p>
 * Example 1:
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 * Example 2:
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 * Example 3:
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 */
public class Solution383 {

    public boolean canConstruct(String ransomNote, String magazine) {
        if(magazine.length() < ransomNote.length()) {
            return false;
        }
        int[] letters = new int[26];
        char[] magazineCharArray = magazine.toCharArray();
        for (char c : magazineCharArray) {
            int index = c - 'a';
            letters[index] = letters[index] + 1;
        }
        for(int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            int index = c - 'a';
            if(letters[index] == 0) {
                return false;
            }
            letters[index] = letters[index] - 1;
        }
        return true;
    }

    public static void main(String[] args) {

        // Example 1
        String ransomNote = "a", magazine = "b";
        System.out.println("Input:    ransomNote = " + ransomNote + ", magazine = " + magazine);
        System.out.println("Output:   " + new Solution383().canConstruct(ransomNote, magazine));
        System.out.println("Expected: false");

        // Example 2
        ransomNote = "aa"; magazine = "ab";
        System.out.println("Input:    ransomNote = " + ransomNote + ", magazine = " + magazine);
        System.out.println("Output:   " + new Solution383().canConstruct(ransomNote, magazine));
        System.out.println("Expected: false");

        // Example 3
        ransomNote = "aa"; magazine = "aab";
        System.out.println("Input:    ransomNote = " + ransomNote + ", magazine = " + magazine);
        System.out.println("Output:   " + new Solution383().canConstruct(ransomNote, magazine));
        System.out.println("Expected: true");
    }
}
