package org.s3m.leetcode.easy._190;


public class SolutionJava190 {

    public int reverseBits(int n) {
        int[] bin = new int[32];
        int i = 0;
        while(n>0) {
            bin[i++] = n % 2;
            n = n / 2;
        }
        int rez=0;
        for(int j = 0; j < 32; j++) {
            rez*=2;
            rez+=bin[j];
        }
        return rez;
    }

    public static void main(String[] args) {
        // Example 1
        int n = 43261596;
        System.out.println("Input:    " + n);
        System.out.println("Output:   " + new SolutionJava190().reverseBits(n));
        System.out.println("Expected: 964176192");

        // Example 2
        n = 2147483644;
        System.out.println("Input:    " + n);
        System.out.println("Output:   " + new SolutionJava190().reverseBits(n));
        System.out.println("Expected: 1073741822");
    }
}
