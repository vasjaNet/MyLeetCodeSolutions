package org.s3m.leetcode.easy._13;


import java.util.Map;

public class SolutionJava13 {

    private static final Map<Character, Integer> symbols = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
    );
    public int romanToInt(String s) {
        int result = 0;
        int val = symbols.get(s.charAt(0));
        for(int i = 1; i < s.length(); i++) {
            int next = symbols.get(s.charAt(i));;
            if (val >= next) {
                result += val;
            } else {
                result -= val;
            }
            val = next;
        }
        result += val;
        return result;
    }

    public static void main(String[] args) {
        // Example 1
        String s = "III";
        System.out.println("Input:    " + s);
        System.out.println("Output:   " + new SolutionJava13().romanToInt(s));
        System.out.println("Expected: 3");

        // Example 2
        s = "LVIII";
        System.out.println("Input:    " + s);
        System.out.println("Output:   " + new SolutionJava13().romanToInt(s));
        System.out.println("Expected: 58");

        // Example 3
        s = "MCMXCIV";
        System.out.println("Input:    " + s);
        System.out.println("Output:   " + new SolutionJava13().romanToInt(s));
        System.out.println("Expected: 1994");

    }
}
