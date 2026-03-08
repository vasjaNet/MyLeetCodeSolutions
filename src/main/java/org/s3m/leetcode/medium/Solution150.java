package org.s3m.leetcode.medium;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Evaluate Reverse Polish Notation
 * <p>
 * You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
 * Evaluate the expression. Return an integer that represents the value of the expression.
 * Note that:
 * The valid operators are '+', '-', '*', and '/'.
 * Each operand may be an integer or another expression.
 * The division between two integers always truncates toward zero.
 * There will not be any division by zero.
 * The input represents a valid arithmetic expression in a reverse polish notation.
 * The answer and all the intermediate calculations can be represented in a 32-bit integer.
 * <p>
 * Example 1:
 * Input: tokens = ["2","1","+","3","*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 * Example 2:
 * Input: tokens = ["4","13","5","/","+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 * Example 3:
 * Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * Output: 22
 * Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 */
public class Solution150 {

    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(String token : tokens) {
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    stack.push(-stack.pop() + stack.pop());
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/": {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b/a);
                    break;
                }
                default:
                    stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }


    public static void main(String[] args) {

        // Example 1
        String[] tokens = {"2","1","+","3","*"};
        System.out.println("Input:    " + Arrays.toString(tokens));
        //System.out.println("Output:   " + new Solution150().evalRPN(tokens));
        System.out.println("Expected: 9");

        // Example 2
        tokens = new String[]{"4","13","5","/","+"};
        System.out.println("Input:    " + Arrays.toString(tokens));
        System.out.println("Output:   " + new Solution150().evalRPN(tokens));
        System.out.println("Expected: 6");

        // Example 3
        tokens = new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println("Input:    " + Arrays.toString(tokens));
        System.out.println("Output:   " + new Solution150().evalRPN(tokens));
        System.out.println("Expected: 22");

    }
}
