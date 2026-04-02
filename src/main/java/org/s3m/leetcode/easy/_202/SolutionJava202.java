package org.s3m.leetcode.easy._202;


import java.util.HashSet;
import java.util.Set;

public class SolutionJava202 {

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(n != 1) {
            if(set.contains(n)) return false;
            set.add(n);
            int sum = 0;
            while(n > 0) {
                sum += (n % 10) * (n % 10);
                n = n / 10;
            }
            n = sum;
        }
        return true;
    }

    public static void main(String[] args) {
        // Example 1
        int n = 19;
        System.out.println("Input:    " + n);
        System.out.println("Output:   " + new SolutionJava202().isHappy(n));
        System.out.println("Expected: true");

        // Example 2
        n = 2;
        System.out.println("Input:    " + n);
        System.out.println("Output:   " + new SolutionJava202().isHappy(n));
        System.out.println("Expected: false");

    }
}
