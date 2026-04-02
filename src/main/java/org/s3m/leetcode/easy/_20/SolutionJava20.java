package org.s3m.leetcode.easy._20;


import java.util.*;

public class SolutionJava20 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if(stack.isEmpty()) return false;
                else if(c == ')' && stack.peek() == '(') stack.pop();
                else if(c == ']' && stack.peek() == '[') stack.pop();
                else if(c == '}' && stack.peek() == '{') stack.pop();
                else return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        // Example 1
        String s = "()";
        System.out.println("Input:    " + s);
        System.out.println("Output:   " + new SolutionJava20().isValid(s));
        System.out.println("Expected: true");

        // Example 2
        s = "()[]{}";
        System.out.println("Input:    " + s);
        System.out.println("Output:   " + new SolutionJava20().isValid(s));
        System.out.println("Expected: true");

        // Example 3
        s = "(]";
        System.out.println("Input:    " + s);
        System.out.println("Output:   " + new SolutionJava20().isValid(s));
        System.out.println("Expected: false");



    }
}
