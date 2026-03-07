package org.s3m.leetcode.easy;


import java.util.*;

/**
 * Valid Parentheses
 * <p>
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * 1.Open brackets must be closed by the same type of brackets.
 * 2.Open brackets must be closed in the correct order.
 * 3.Every close bracket has a corresponding open bracket of the same type.
 * <p>
 * Example 1:
 * Input: s = "()"
 * Output: true
 * Example 2:
 * Input: s = "()[]{}"
 * Output: true
 * Example 3:
 * Input: s = "(]"
 * Output: false
 * Example 4:
 * Input: s = "([])"
 * Output: true
 * Example 5:
 * Input: s = "([)]"
 * Output: false
 */
public class Solution20 {

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
        System.out.println("Output:   " + new Solution20().isValid(s));
        System.out.println("Expected: true");

        // Example 2
        s = "()[]{}";
        System.out.println("Input:    " + s);
        System.out.println("Output:   " + new Solution20().isValid(s));
        System.out.println("Expected: true");

        // Example 3
        s = "(]";
        System.out.println("Input:    " + s);
        System.out.println("Output:   " + new Solution20().isValid(s));
        System.out.println("Expected: false");



    }
}
