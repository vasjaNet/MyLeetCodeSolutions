package org.s3m.leetcode.hard;


import java.util.*;

/**
 * Candy
 * <p>
 * There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.
 * You are giving candies to these children subjected to the following requirements:
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * Return the minimum number of candies you need to have to distribute the candies to the children.
 * <p>
 * Example 1:
 * Input: ratings = [1,0,2]
 * Output: 5
 * Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
 * Example 2:
 * Input: ratings = [1,2,2]
 * Output: 4
 * Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
 * The third child gets 1 candy because it satisfies the above two conditions.
 */
public class Solution135 {

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
        System.out.println("Output:   " + new Solution135().candy(ratings));
        System.out.println("Expected: 5");

        // Example 2
        ratings = new int[]{1,2,2};
        System.out.println("Input:    " + Arrays.toString(ratings));
        System.out.println("Output:   " + new Solution135().candy(ratings));
        System.out.println("Expected: 4");

    }

}
