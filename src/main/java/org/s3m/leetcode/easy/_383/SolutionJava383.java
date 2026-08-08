package org.s3m.leetcode.easy._383;



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
        String pattern = "a", s = "b";
        System.out.println("Input:    " + pattern + ", " + s);
        System.out.println("Output:   " + new SolutionJava383().canConstruct(pattern, s));
        System.out.println("Expected: false");

        // Example 2
        pattern = "aa"; s = "ab";
        System.out.println("Input:    " + pattern + ", " + s);
        System.out.println("Output:   " + new SolutionJava383().canConstruct(pattern, s));
        System.out.println("Expected: false");

        // Example 3
        pattern = "aa"; s = "aab";
        System.out.println("Input:    " + pattern + ", " + s);
        System.out.println("Output:   " + new SolutionJava383().canConstruct(pattern, s));
        System.out.println("Expected: false");
    }
}
