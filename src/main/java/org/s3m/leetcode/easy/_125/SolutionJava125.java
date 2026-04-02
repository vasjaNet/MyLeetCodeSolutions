package org.s3m.leetcode.easy._125;


import java.util.*;

public class SolutionJava125 {

    public boolean isPalindrome(String s) {

        int startIndex = 0;
        int endIndex = s.length() - 1;

        Set<Character> map = new HashSet<>();

           while(endIndex-startIndex > 0) {
            System.out.println("startIndex: " + startIndex + " endIndex: " + endIndex);
            Character b = s.charAt(startIndex);
            Character e = s.charAt(endIndex);
            boolean bIsDigit = '0' <= b && b <= '9';
            boolean bIsUpperCharacterSimbol = 'A' <= b && b <= 'Z';
            boolean bIsCharacterSimbol = 'a' <= b && b <= 'z' || bIsUpperCharacterSimbol || bIsDigit;

            boolean eIsDigit = '0' <= e && e <= '9';
            boolean eIsUpperCharacterSimbol = 'A' <= e && e <= 'Z';
            boolean eIsCharacterSimbol = 'a' <= e && e <= 'z' || eIsUpperCharacterSimbol || eIsDigit;

            if(!bIsCharacterSimbol) {
                startIndex++;
            }

            if(!eIsCharacterSimbol) {
                endIndex--;
            }

            if ( !bIsCharacterSimbol || !eIsCharacterSimbol) continue;

            if (bIsUpperCharacterSimbol) {
                b = Character.toLowerCase(b);
            }
            if (eIsUpperCharacterSimbol) {
                e = Character.toLowerCase(e);
            }

            if(!b.equals(e)) {
                return false;
            }
            startIndex++;
            endIndex--;
        }
        return true;

    }

    public static void main(String[] args) {
        // Example 1
        String s = "A man, a plan, a canal: Panama";
        System.out.println("Input:    " + s);
        System.out.println("Output:   " + new SolutionJava125().isPalindrome(s));
        System.out.println("Expected: true");

        // Example 2
        s = "race a car";
        System.out.println("Input:    " + s);
        System.out.println("Output:   " + new SolutionJava125().isPalindrome(s));
        System.out.println("Expected: false");

        // Example 3
        s = " ";
        System.out.println("Input:    " + s);
        System.out.println("Output:   " + new SolutionJava125().isPalindrome(s));
        System.out.println("Expected: true");

        // Example 4
        s = "0P";
        System.out.println("Input:    " + s);
        System.out.println("Output:   " + new SolutionJava125().isPalindrome(s));
        System.out.println("Expected: false");
        Queue<Integer> tmpQueue = new ArrayDeque<>();

    }
}
