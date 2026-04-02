package org.s3m.leetcode.medium._17;


import java.util.ArrayList;
import java.util.List;

public class SolutionJava17 {
    char[][] mapping = new char[][]{
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
    };
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) return new ArrayList<>();
        List<String> result = new ArrayList<>();
        char[][] tmp = letterCombinations(digits, 0);
        for (char[] chars : tmp) {
            result.add(new String(chars));
        }
        return result;
    }

    private char[][] letterCombinations(String digits, int index) {
        char digit = digits.charAt(index);
        int button = digit - '2';
        var chars = mapping[button];
        if(digits.length() - 1 == index) {
            char[][] result = new char[chars.length][1];
            for(int i = 0; i < chars.length; i++) {
                result[i][0] = chars[i];
            }
            return result;
        }
        char[][] prev = letterCombinations(digits, index + 1);
        char[][] tmp = new char[prev.length * chars.length][digits.length()-index];
        for(int i = 0; i < chars.length; i++) {
            for(int j = 0; j < prev.length; j++) {
                int i1 = j + (prev.length * i);
                tmp[i1][0] = chars[i];
                System.arraycopy(prev[j], 0, tmp[i1], 1, prev[j].length);
            }
        }
        prev = tmp;
        return prev;
    }



    public static void main(String[] args) {

        // Example 1
        String digits1 = "23";
        SolutionJava17 solution = new SolutionJava17();
        List<String> result1 = solution.letterCombinations(digits1);
        System.out.println("Example 1 Output: " + result1);
        System.out.println("Expected: [ad,ae,af,bd,be,bf,cd,ce,cf]");

        // Example 2
        String digits2 = "2";
        List<String> result2 = solution.letterCombinations(digits2);
        System.out.println("Example 2 Output: " + result2);
        System.out.println("Expected: [a,b,c]");

    }
}
