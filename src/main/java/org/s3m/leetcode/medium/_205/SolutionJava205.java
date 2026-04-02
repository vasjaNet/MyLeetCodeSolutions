package org.s3m.leetcode.medium._205;


import java.util.HashMap;
import java.util.Map;

public class SolutionJava205 {

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
        System.out.println("Output:   " + new SolutionJava205().isIsomorphic(s, t));
        System.out.println("Expected: true");

        // Example 2
        s = "f11"; t = "b23";
        System.out.println("Input:    s = " + s + ", t = " + t);
        System.out.println("Output:   " + new SolutionJava205().isIsomorphic(s, t));
        System.out.println("Expected: false");

        // Example 3
        s = "paper"; t = "title";
        System.out.println("Input:    s = " + s + ", t = " + t);
        System.out.println("Output:   " + new SolutionJava205().isIsomorphic(s, t));
        System.out.println("Expected: true");

        // Example 4
        s = "badc"; t = "baba";
        System.out.println("Input:    s = " + s + ", t = " + t);
        System.out.println("Output:   " + new SolutionJava205().isIsomorphic(s, t));
        System.out.println("Expected: false");
    }
}
