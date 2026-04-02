package org.s3m.leetcode.medium._3;


import java.util.HashSet;
import java.util.Set;

public class SolutionJava3 {

    public static int lengthOfLongestSubstring(String s) {
        int slov = 0;
        int f = 0;
        int maxLength = 0;
        char[] a = s.toCharArray();
        Set<Character> set = new HashSet<>();
        while(f < a.length) {
            char lastChar = a[f];
            if(set.contains(lastChar)) {
                set.remove(a[slov++]);
            } else {
                set.add(lastChar);
                int length = f-slov+1;
                if (maxLength < length) {
                    maxLength = length;
                }
                f++;
            }
        }
        return maxLength;

    }

    public static void main(String[] args) {
        // Example 1
        String s = "abcabcbb";
        System.out.println("Input:    " + s);
        System.out.println("Output:   " + lengthOfLongestSubstring(s));
        System.out.println("Expected: 3");

        // Example 2
        s = "bbbbb";
        System.out.println("Input:    " + s);
        System.out.println("Output:   " + lengthOfLongestSubstring(s));
        System.out.println("Expected: 1");

        // Example 3
        s = "pwwkew";
        System.out.println("Input:    " + s);
        System.out.println("Output:   " + lengthOfLongestSubstring(s));
        System.out.println("Expected: 3");

    }
}
