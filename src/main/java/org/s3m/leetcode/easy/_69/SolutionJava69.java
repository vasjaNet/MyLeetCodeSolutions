package org.s3m.leetcode.easy._69;



public class SolutionJava69 {

    //todo: use binary search
    public int mySqrt(int x) {
        long sqrt = 0;
        int res = 0;
        if(x > 100) res = 10;
        if(x > 10000) res = 100;
        if(x > 1000000) res = 1000;
        if(x > 100000000) res = 10000;
        if(x > 400000000) res = 20000;
        if(x > 900000000) res = 30000;
        if(x > 2025000000) res = 45000;
        while (sqrt <= x) {
            res++;
            sqrt = (long)res * (long)res;

        }
        return res-1;
    }

    public static void main(String[] args) {
        // Example 1
        int x = 4;
        System.out.println("Input:    " + x);
        System.out.println("Output:   " + new SolutionJava69().mySqrt(x));
        System.out.println("Expected: 2");

        // Example 2
        x = 8;
        System.out.println("Input:    " + x);
        System.out.println("Output:   " + new SolutionJava69().mySqrt(x));
        System.out.println("Expected: 2");
    }
}
