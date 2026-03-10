package org.s3m.leetcode.medium;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Combination Sum
 * <p>
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
 * The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 * <p>
 * Example 1:
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 * Example 2:
 * Input: candidates = [2,3,5], target = 8
 * Output: [[2,2,2,2],[2,3,3],[3,5]]
 * Example 3:
 * Input: candidates = [2], target = 1
 * Output: []
 */
public class Solution39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSum(candidates, target, 0, result, new LinkedList<>());
        return result;
    }

    private void combinationSum(int[] candidates, int target, int index, List<List<Integer>> result, List<Integer> list) {
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                list.add(candidates[i]);
                if(target - candidates[i] >= 0) {
                    combinationSum(candidates, target - candidates[i], i, result, list);
                    list.removeLast();
                }
            }
        }
    }



    public static void main(String[] args) {

        // Example 1
        int[] candidates = {2,3,6,7};
        int target = 7;
        System.out.println("Input:    " + candidates + ", " + target);
        System.out.println("Output:   " + new Solution39().combinationSum(candidates, target));
        System.out.println("Expected: [[2,2,3],[7]]");

        // Example 2
        candidates = new int[]{2,3,5};
        target = 8;
        System.out.println("Input:    " + candidates + ", " + target);
        System.out.println("Output:   " + new Solution39().combinationSum(candidates, target));
        System.out.println("Expected: [[2, 2, 2, 2], [2, 3, 3], [3, 5]]");


    }
}
