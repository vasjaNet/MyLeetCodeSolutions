package org.s3m.leetcode.medium._12;


public class SolutionJava12 {

    public String intToRoman(int num) {
        String result = "";
        int[] roman = new int[]{900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanStr = new String[]{ "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        if(num > 1000) {
            int count = num / 1000;
            result = String.valueOf('M').repeat(count);
            num -= count * 1000;
        }
        for(int i = 0; i < roman.length; i++) {
            while(num >= roman[i]) {
                result += romanStr[i];
                num -= roman[i];
            }
        }
        return result;
    }


    public static void main(String[] args) {

        // Example 1
        int num = 3749;
        System.out.println("Input:    " + num);
        System.out.println("Output:   " + new SolutionJava12().intToRoman(num));
        System.out.println("Expected: MMMDCCXLIX");

        // Example 2
        num = 58;
        System.out.println("Input:    " + num);
        System.out.println("Output:   " + new SolutionJava12().intToRoman(num));
        System.out.println("Expected: LVIII");

        // Example 3
        num = 1994;
        System.out.println("Input:    " + num);
        System.out.println("Output:   " + new SolutionJava12().intToRoman(num));
        System.out.println("Expected: MCMXCIV");



    }
}
