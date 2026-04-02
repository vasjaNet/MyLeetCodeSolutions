package org.s3m.leetcode.hard._135;


import java.util.*;

public class SolutionJava135 {

    public int candy(int[] ratings) {
        int[] left = new int[ratings.length];
        left[0] = 1;
        int[] right = new int[ratings.length];
        right[ratings.length - 1] = 1;
        for(int i = 1; i < ratings.length; i++) {
            left[i] = ratings[i] > ratings[i-1] ? left[i-1] + 1 : 1;
        }
        for(int i = ratings.length - 2; i >= 0; i--) {
            right[i] = ratings[i] > ratings[i+1] ? right[i+1] + 1 : 1;
        }
        int result = 0;
        for(int i = 0; i < ratings.length; i++) {
            result += Math.max(left[i], right[i]);
        }
        return result;
    }

    public static void main(String[] args) {

        // Example 1
        int[] ratings = {1,0,2};
        System.out.println("Input:    " + Arrays.toString(ratings));
        System.out.println("Output:   " + new SolutionJava135().candy(ratings));
        System.out.println("Expected: 5");

        // Example 2
        ratings = new int[]{1,2,2};
        System.out.println("Input:    " + Arrays.toString(ratings));
        System.out.println("Output:   " + new SolutionJava135().candy(ratings));
        System.out.println("Expected: 4");

    }

}
