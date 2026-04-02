package org.s3m.leetcode.easy._28;



public class SolutionJava28 {

    public int strStr(String haystack, String needle) {
        if(haystack.length() < needle.length()) return -1;
        boolean equals;
        int i = 0;
        do{
            equals = true;
            for(int j=0; j < needle.length(); j++) {
                if(haystack.charAt(i+j) != needle.charAt(j)) {
                    equals = false;
                    break;
                }
            }
            if(equals) return i;
            i++;
        } while(i <= haystack.length()-needle.length());
        return -1;
    }

    public static void main(String[] args) {
        // Example 1
        String haystack = "sadbutsad";
        String needle = "sad";
        System.out.println("Input:    " + haystack + ", " + needle);
        System.out.println("Output:   " + new SolutionJava28().strStr(haystack, needle));
        System.out.println("Expected: 0");

        // Example 2
        haystack = "leetcode";
        needle = "leeto";
        System.out.println("Input:    " + haystack + ", " + needle);
        System.out.println("Output:   " + new SolutionJava28().strStr(haystack, needle));
        System.out.println("Expected: -1");

        // Example 3
        haystack = "a";
        needle = "a";
        System.out.println("Input:    " + haystack + ", " + needle);
        System.out.println("Output:   " + new SolutionJava28().strStr(haystack, needle));
        System.out.println("Expected: 0");

        // Example 3
        haystack = "abc";
        needle = "c";
        System.out.println("Input:    " + haystack + ", " + needle);
        System.out.println("Output:   " + new SolutionJava28().strStr(haystack, needle));
        System.out.println("Expected: 2");

    }
}
