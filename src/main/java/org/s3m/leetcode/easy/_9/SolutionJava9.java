package org.s3m.leetcode.easy._9;

public class SolutionJava9 {

    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        String original = String.valueOf(x);
        String revers = new StringBuilder(String.valueOf(x)).reverse().toString();
        return original.equals(revers);
    }

    public static void main(String[] args) {
        // Example 1
        int x = 121;
        System.out.println("Input:    " + x);
        System.out.println("Output:   " + new SolutionJava9().isPalindrome(x));
        System.out.println("Expected: true");

        // Example 2
        x = -121;
        System.out.println("Input:    " + x);
        System.out.println("Output:   " + new SolutionJava9().isPalindrome(x));
        System.out.println("Expected: false");

        // Example 3
        x = 10;
        System.out.println("Input:    " + x);
        System.out.println("Output:   " + new SolutionJava9().isPalindrome(x));
        System.out.println("Expected: false");
    }


}
