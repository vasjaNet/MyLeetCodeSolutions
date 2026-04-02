package org.s3m.leetcode.easy._868;


public class SolutionJava868 {

    public int hammingWeight(int n) {
        int count = 0;
        while(n>0) {
            if(n % 2 == 1) count++;
            n = n >> 1;
        }
        return count;
    }

    public int binaryGap(int n) {
        int max = 0;
        int start = 0;
        int count = 0;
        int onesCounts = 0;
        while(n > 0) {
            if (n % 2 == 1) {
                onesCounts++;
                start = count;
            } else {
                if(onesCounts > 0) {
                    max = Math.max(max, count - start + 1);
                }
            }
            count++;
            n = n >> 1;
        }
        if(onesCounts > 1) {
            max = Math.max(max, count - start);
        }
        return max;
    }

    public static void main(String[] args) {


        // Example 1
        int n = 22;
        System.out.println("Input:    " + n);
        System.out.println("Output:   " + new SolutionJava868().binaryGap(n));
        System.out.println("Expected: 2");

        // Example 2
        n = 8;
        System.out.println("Input:    " + n);
        System.out.println("Output:   " + new SolutionJava868().binaryGap(n));
        System.out.println("Expected: 0");

        // Example 3
        n = 5;
        System.out.println("Input:    " + n);
        System.out.println("Output:   " + new SolutionJava868().binaryGap(n));
        System.out.println("Expected: 2");

        // Example 4
        n = 6;
        System.out.println("Input:    " + n);
        System.out.println("Output:   " + new SolutionJava868().binaryGap(n));
        System.out.println("Expected: 1");

    }
}
