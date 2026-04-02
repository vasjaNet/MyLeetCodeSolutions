package org.s3m.leetcode.medium._151;


public class SolutionJava151 {

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
        System.out.println("Output:   " + new SolutionJava151().reverseWords(s1));
        System.out.println("Expected: blue is sky the");

        // Example 2
        String s2 = "  hello world  ";
        System.out.println("Input:    " + s2);
        System.out.println("Output:   " + new SolutionJava151().reverseWords(s2));
        System.out.println("Expected: world hello");

        // Example 3
        String s3 = "a good   example";
        System.out.println("Input:    " + s3);
        System.out.println("Output:   " + new SolutionJava151().reverseWords(s3));
        System.out.println("Expected: example good a");


    }
}
