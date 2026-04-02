package org.s3m.leetcode.medium._39;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SolutionJava39 {

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
        System.out.println("Output:   " + new SolutionJava39().combinationSum(candidates, target));
        System.out.println("Expected: [[2,2,3],[7]]");

        // Example 2
        candidates = new int[]{2,3,5};
        target = 8;
        System.out.println("Input:    " + candidates + ", " + target);
        System.out.println("Output:   " + new SolutionJava39().combinationSum(candidates, target));
        System.out.println("Expected: [[2, 2, 2, 2], [2, 3, 3], [3, 5]]");


    }
}
