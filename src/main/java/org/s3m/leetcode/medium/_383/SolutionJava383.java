package org.s3m.leetcode.medium._383;


public class SolutionJava383 {

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
        System.out.println("Output:   " + new SolutionJava383().canConstruct(ransomNote, magazine));
        System.out.println("Expected: false");

        // Example 2
        ransomNote = "aa"; magazine = "ab";
        System.out.println("Input:    ransomNote = " + ransomNote + ", magazine = " + magazine);
        System.out.println("Output:   " + new SolutionJava383().canConstruct(ransomNote, magazine));
        System.out.println("Expected: false");

        // Example 3
        ransomNote = "aa"; magazine = "aab";
        System.out.println("Input:    ransomNote = " + ransomNote + ", magazine = " + magazine);
        System.out.println("Output:   " + new SolutionJava383().canConstruct(ransomNote, magazine));
        System.out.println("Expected: true");
    }
}
