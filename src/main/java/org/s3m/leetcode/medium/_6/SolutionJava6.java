package org.s3m.leetcode.medium._6;


import java.util.Arrays;

public class SolutionJava6 {

    public String convert(String s, int numRows) {
        char[] chars = s.toCharArray();
        if(numRows < 2) return s;
        char[] result = new char[chars.length];
        int midCount = numRows - 2;
        int firstShift = numRows + midCount;
        int secondShift = 0;
        int k = 0;
        for(int i = 0; i < numRows; i++) {
            int j = i;
            while(j < chars.length) {
                if(firstShift != 0) {
                    result[k++] = chars[j];
                }
                j += firstShift;
                if(j >= chars.length) break;
                if(secondShift != 0) {
                    result[k++] = chars[j];
                }
                j += secondShift;
            }
            firstShift-= 2;
            secondShift+=2;
        }

        return new String(result);
    }

    public static void main(String[] result) {

        // Example 1
        String s = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println("Input:    " + s + ", " + numRows);
        System.out.println("Output:   " + new SolutionJava6().convert(s, numRows));
        System.out.println("Expected: [PAHNAPLSIIGYIR]");

        // Example 2
        s = "PAYPALISHIRING";
        numRows = 4;
        System.out.println("Input:    " + s + ", " + numRows);
        System.out.println("Output:   " + new SolutionJava6().convert(s, numRows));
        System.out.println("Expected: [PINALSIGYAHRPI]");

    }
}
