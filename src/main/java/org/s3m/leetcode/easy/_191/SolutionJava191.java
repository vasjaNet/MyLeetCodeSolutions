package org.s3m.leetcode.easy._191;


public class SolutionJava191 {

    public int hammingWeight(int n) {
        int count = 0;
        while(n>0) {
            if(n % 2 == 1) count++;
            n = n >> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        // Example 1
        int n = 11;
        System.out.println("Input:    " + n);
        System.out.println("Output:   " + new SolutionJava191().hammingWeight(n));
        System.out.println("Expected: 3");

        // Example 2
        n = 128;
        System.out.println("Input:    " + n);
        System.out.println("Output:   " + new SolutionJava191().hammingWeight(n));
        System.out.println("Expected: 1");

        // Example 3
        n = 2147483645;
        System.out.println("Input:    " + n);
        System.out.println("Output:   " + new SolutionJava191().hammingWeight(n));
        System.out.println("Expected: 30");
    }
}
