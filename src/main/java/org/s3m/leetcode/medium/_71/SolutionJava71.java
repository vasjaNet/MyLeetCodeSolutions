package org.s3m.leetcode.medium._71;


import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionJava71 {

    public String simplifyPath(String path) {
        StringBuilder result = new StringBuilder();
        String[] paths = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        for (String p : paths) {
            if (p.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!p.equals(".") && !p.isEmpty()) {
                stack.push(p);
            }
        }
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
            result.insert(0, "/" );
        }

        return result.toString().isEmpty() ? "/" : result.toString();
    }

    public static void main(String[] args) {
        // Example 1
        String path = "/home/";
        System.out.println("Input:    " + path);
        System.out.println("Output:   " + new SolutionJava71().simplifyPath(path));
        System.out.println("Expected: /home");

        // Example 2
        path = "/home//foo/";
        System.out.println("Input:    " + path);
        System.out.println("Output:   " + new SolutionJava71().simplifyPath(path));
        System.out.println("Expected: /home/foo");

        // Example 3
        path = "/home/user/Documents/../Pictures";
        System.out.println("Input:    " + path);
        System.out.println("Output:   " + new SolutionJava71().simplifyPath(path));
        System.out.println("Expected: /home/user/Pictures");



    }
}
