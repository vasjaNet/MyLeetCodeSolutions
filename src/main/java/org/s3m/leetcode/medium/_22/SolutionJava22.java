package org.s3m.leetcode.medium._22;


import java.util.*;

public class SolutionJava22 {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        combine(n-1, sb, 1, 1, result);
        return result;
    }

    private void combine(int n, StringBuilder list, int open, int close, List<String> result) {
        if(list.length() == n * 2) {
            list.insert(0, "(");
            list.append(")");
            result.add(list.toString());
            return;
        }
        if(open <= n) {
            combine(n, list.append("("), open + 1, close, result);
        }
        if(close <= open) {
            combine(n, list.append(")"), open, close + 1, result);
        }
    }



    public static void main(String[] args) {

        // Example 1
        int n = 3;
        System.out.println(new SolutionJava22().generateParenthesis(n));

        // Example 2
        n = 1;
        System.out.println(new SolutionJava22().generateParenthesis(n));


    }
}
