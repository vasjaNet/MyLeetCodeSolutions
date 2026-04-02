package org.s3m.leetcode.hard._76;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionJava76 {

    public String minWindow(String s, String t) {
        String result = "";
        int length = s.length();
        if(length < t.length()) return result;
        int[] tMap = new int[256];
        for(char c : t.toCharArray()) {
            ++tMap[c];
        }
        int[] sMap = new int[256];
        char[] sCharArray = s.toCharArray();
        int left = 0;
        int right = 0;
        for(int i = 0; i < length; i++) {
            if(t.indexOf(sCharArray[i]) >0) {
                left = i;
                right = i;
                break;
            }
        }
        int count = t.length();
        while(right < length) {
            char c = sCharArray[right];
            ++sMap[c];
            if(sMap[c] <= tMap[c]) {
                count--;
            }
            while(count == 0) {
                if(result.isEmpty() || right - left + 1 < result.length()) {
                    result = s.substring(left, right + 1);
                }
                char d = sCharArray[left];
                --sMap[d];
                if(sMap[d] < tMap[d]) {
                    count++;
                }
                left++;
            }
            right++;
        }
        return result;
    }

    public static void main(String[] args) {
        // Example 1
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println("Input:    " + s + ", " + t);
        System.out.println("Output:   " + new SolutionJava76().minWindow(s, t));
        System.out.println("Expected: BANC");

        // Example 2
        s = "a";
        t = "a";
        System.out.println("Input:    " + s + ", " + t);
        System.out.println("Output:   " + new SolutionJava76().minWindow(s, t));
        System.out.println("Expected: a");

        // Example 3
        s = "a";
        t = "aa";
        System.out.println("Input:    " + s + ", " + t);
        System.out.println("Output:   " + new SolutionJava76().minWindow(s, t));
        System.out.println("Expected: ");

    }

}
