package org.s3m.leetcode.easy;


import java.util.Map;

/**
 * Roman to Integer
 * <p>
 * For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer.
 * <p>
 * Example 1:
 * Input: s = "III"
 * Output: 3
 * Explanation: III = 3.
 * Example 2:
 * Input: s = "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * Example 3:
 * Input: s = "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */
public class Solution13 {

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
        System.out.println("Output:   " + new Solution13().romanToInt(s));
        System.out.println("Expected: 3");

        // Example 2
        s = "LVIII";
        System.out.println("Input:    " + s);
        System.out.println("Output:   " + new Solution13().romanToInt(s));
        System.out.println("Expected: 58");

        // Example 3
        s = "MCMXCIV";
        System.out.println("Input:    " + s);
        System.out.println("Output:   " + new Solution13().romanToInt(s));
        System.out.println("Expected: 1994");

    }
}
