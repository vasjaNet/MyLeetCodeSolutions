package org.s3m.leetcode.medium;


/**
 * Reverse Words in a String
 * <p>
 * Given an input string s, reverse the order of the words.
 * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
 * Return a string of the words in reverse order concatenated by a single space.
 * Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.
 * <p>
 * Example 1:
 * Input: s = "the sky is blue"
 * Output: "blue is sky the"
 * Example 2:
 * Input: s = "  hello world  "
 * Output: "world hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 * Example 3:
 * Input: s = "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 */
public class Solution151 {

    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if(words[i].isEmpty()) continue;
            sb.append(words[i]);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    public static void main(String[] args) {

        // Example 1
        String s1 = "the sky is blue";
        System.out.println("Input:    " + s1);
        System.out.println("Output:   " + new Solution151().reverseWords(s1));
        System.out.println("Expected: blue is sky the");

        // Example 2
        String s2 = "  hello world  ";
        System.out.println("Input:    " + s2);
        System.out.println("Output:   " + new Solution151().reverseWords(s2));
        System.out.println("Expected: world hello");

        // Example 3
        String s3 = "a good   example";
        System.out.println("Input:    " + s3);
        System.out.println("Output:   " + new Solution151().reverseWords(s3));
        System.out.println("Expected: example good a");


    }
}
