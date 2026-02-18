package org.s3m.leetcode.medium;


import java.util.Arrays;

/**
 * Two Sum II - Input Array Is Sorted
 * <p>
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
 * Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
 * The tests are generated such that there is exactly one solution. You may not use the same element twice.
 * Your solution must use only constant extra space.
 * <p>
 * Example 1:
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
 * Example 2:
 * Input: numbers = [2,3,4], target = 6
 * Output: [1,3]
 * Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
 * Example 3:
 * Input: numbers = [-1,0], target = -1
 * Output: [1,2]
 * Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].
 */
public class Solution167 {

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
        System.out.println("Output:   " + Arrays.toString(new Solution167().twoSum(numbers, target)));
        System.out.println("Expected: [1,2]");

        Character.getNumericValue('0');
        // Example 2
        numbers = new int[]{2,3,4};
        target = 6;
        System.out.println("Input:    " + Arrays.toString(numbers));
        System.out.println("Output:   " + Arrays.toString(new Solution167().twoSum(numbers, target)));
        System.out.println("Expected: [1,3]");

        // Example 3
        numbers = new int[]{-1,0};
        target = -1;
        System.out.println("Input:    " + Arrays.toString(numbers));
        System.out.println("Output:   " + Arrays.toString(new Solution167().twoSum(numbers, target)));
        System.out.println("Expected: [1,2]");

    }
}
