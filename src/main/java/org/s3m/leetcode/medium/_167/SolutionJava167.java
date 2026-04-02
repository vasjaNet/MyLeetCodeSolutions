package org.s3m.leetcode.medium._167;


import java.util.Arrays;

public class SolutionJava167 {

    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        while(l < r) {
            int rn = numbers[r];
            int ln  = numbers[l];
            if (ln + rn == target) return new int[]{l+1, r+1};
            if (ln + rn > target) {
                r--;
            } else if (ln + rn < target) {
                l++;
            }
        }
        return new int[]{l+1, r+1};
    }

    public static void main(String[] args) {
        // Example 1
        int[] numbers = {2,7,11,15};
        int target = 9;
        System.out.println("Input:    " + Arrays.toString(numbers));
        System.out.println("Output:   " + Arrays.toString(new SolutionJava167().twoSum(numbers, target)));
        System.out.println("Expected: [1,2]");

        Character.getNumericValue('0');
        // Example 2
        numbers = new int[]{2,3,4};
        target = 6;
        System.out.println("Input:    " + Arrays.toString(numbers));
        System.out.println("Output:   " + Arrays.toString(new SolutionJava167().twoSum(numbers, target)));
        System.out.println("Expected: [1,3]");

        // Example 3
        numbers = new int[]{-1,0};
        target = -1;
        System.out.println("Input:    " + Arrays.toString(numbers));
        System.out.println("Output:   " + Arrays.toString(new SolutionJava167().twoSum(numbers, target)));
        System.out.println("Expected: [1,2]");

    }
}
