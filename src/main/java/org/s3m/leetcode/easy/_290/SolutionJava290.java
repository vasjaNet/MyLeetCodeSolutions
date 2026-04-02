package org.s3m.leetcode.easy._290;


import java.util.HashMap;
import java.util.Map;

public class SolutionJava290 {


    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if(words.length != pattern.length()) return false;
        Map<Character, String> map = new HashMap<>();
        for(int i = 0; i < words.length; i++) {
            String word = words[i];
            char c = pattern.charAt(i);
            if(map.containsKey(c) && !map.get(c).equals(word)) {
                return false;
            }
            if(!map.containsKey(c) && map.containsValue(word)) {
                return false;
            }
            map.put(c, word);
        }
        return true;
    }




    public static void main(String[] args) {
        // Example 1
        String pattern = "abba", s = "dog cat cat dog";
        System.out.println("Input:    " + pattern + ", " + s);
        System.out.println("Output:   " + new SolutionJava290().wordPattern(pattern, s));
        System.out.println("Expected: true");

        // Example 2
        pattern = "abba"; s = "dog cat cat fish";
        System.out.println("Input:    " + pattern + ", " + s);
        System.out.println("Output:   " + new SolutionJava290().wordPattern(pattern, s));
        System.out.println("Expected: false");

        // Example 3
        pattern = "aaaa"; s = "dog cat cat dog";
        System.out.println("Input:    " + pattern + ", " + s);
        System.out.println("Output:   " + new SolutionJava290().wordPattern(pattern, s));
        System.out.println("Expected: false");
    }
}
