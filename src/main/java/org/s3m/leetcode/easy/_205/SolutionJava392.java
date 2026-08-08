package org.s3m.leetcode.easy._205;


import java.util.HashMap;
import java.util.Map;

public class SolutionJava392 {

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
            if(mapping.getOrDefault(sChar, tChar) == tChar
                    && reversMapping.getOrDefault(tChar, sChar) == sChar) {
                mapping.put(sChar, tChar);
                reversMapping.put(tChar, sChar);
            } else  {

                return false;
            }
        }

        return true;
    }

    static void main() {

    }

}
