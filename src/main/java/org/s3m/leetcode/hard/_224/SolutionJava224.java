package org.s3m.leetcode.hard._224;


import java.util.*;

public class SolutionJava224 {

    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int sign = 1;
        int result = 0;
        int num = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '+') {
                result+=sign*num;
                num=0;
                sign = 1;
            } else if (c == '-') {
                result+=sign*num;
                num=0;
                sign = -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result+=sign*num;
                num=0;
                result *= stack.pop();
                result += stack.pop();
            }
        }
        return result+sign*num;
    }

    public static void main(String[] args) {

        // Example 1
        String s = "1 + 1";
        System.out.println("Input:    " + s);
        System.out.println("Output:   " + new SolutionJava224().calculate(s));
        System.out.println("Expected: 2");

        // Example 2
        s = " 2-1 + 2 ";
        System.out.println("Input:    " + s);
        System.out.println("Output:   " + new SolutionJava224().calculate(s));
        System.out.println("Expected: 3");

        // Example 3
        s = "(1+(4+5+2)-3)+(6+8)";
        System.out.println("Input:    " + s);
        System.out.println("Output:   " + new SolutionJava224().calculate(s));
        System.out.println("Expected: 23");



    }
}
