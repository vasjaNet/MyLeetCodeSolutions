package org.s3m.leetcode.easy._66;


import java.util.Arrays;

public class SolutionJava66 {

    public int[] plusOne(int[] digits) {
        int i = digits.length-1;
        int inc = 1;
        do {
            int d = digits[i]+inc;
            if (d > 9) {
                digits[i] = 0;
            } else {
                digits[i] = d;
                inc = 0;
            }
            i--;
        } while (inc == 1 && i >= 0);
        if(inc == 1) {
            int[] newArray = new int[digits.length + 1];
            newArray[0] = 1;
            System.arraycopy(digits, 0, newArray, 1, digits.length);
            return newArray;
        }
        return digits;
    }

    public static void main(String[] args) {
        // Example 1
        int[] digits = {1,2,3};
        System.out.println("Input:    " + Arrays.toString(digits));
        System.out.println("Output:   " + Arrays.toString(new SolutionJava66().plusOne(digits)));
        System.out.println("Expected: [1,2,4]");

        // Example 2
        digits = new int[]{4,3,2,1};
        System.out.println("Input:    " + Arrays.toString(digits));
        System.out.println("Output:   " + Arrays.toString(new SolutionJava66().plusOne(digits)));
        System.out.println("Expected: [4,3,2,2]");

        // Example 3
        digits = new int[]{9};
        System.out.println("Input:    " + Arrays.toString(digits));
        System.out.println("Output:   " + Arrays.toString(new SolutionJava66().plusOne(digits)));
        System.out.println("Expected: [1,0]");

    }
}
