package org.s3m.leetcode.medium._150;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SolutionJava150 {

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
        //System.out.println("Output:   " + new SolutionJava150().evalRPN(tokens));
        System.out.println("Expected: 9");

        // Example 2
        tokens = new String[]{"4","13","5","/","+"};
        System.out.println("Input:    " + Arrays.toString(tokens));
        System.out.println("Output:   " + new SolutionJava150().evalRPN(tokens));
        System.out.println("Expected: 6");

        // Example 3
        tokens = new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println("Input:    " + Arrays.toString(tokens));
        System.out.println("Output:   " + new SolutionJava150().evalRPN(tokens));
        System.out.println("Expected: 22");

    }
}
