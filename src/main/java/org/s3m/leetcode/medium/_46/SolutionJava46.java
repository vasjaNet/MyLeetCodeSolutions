package org.s3m.leetcode.medium._46;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionJava46 {

    private final List<List<Integer>> result = new ArrayList<>();
    private final List<Integer> t = new ArrayList<>();
    private boolean[] vis;

    public List<List<Integer>> permute(int[] nums) {
        vis = new boolean[nums.length];
        dfs(nums, 0);
        return result;
    }

    private void dfs(int[] nums, int i) {
        if (i == nums.length) {
            result.add(new ArrayList<>(t));
            return;
        }
        for (int j = 0; j < nums.length; ++j) {
            if (!vis[j]) {
                vis[j] = true;
                t.add(nums[j]);
                dfs(nums, i + 1);
                t.removeLast();
                vis[j] = false;
            }
        }
    }


    public static void main(String[] args) {

        // Example 1
        int[] nums = {1,2,3};
        System.out.println("Input:    " + Arrays.toString(nums));
        System.out.println("Output:   " + new SolutionJava46().permute(nums));
        System.out.println("Expected: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]");

        // Example 2
        nums = new int[]{0,1};
        System.out.println("Input:    " + Arrays.toString(nums));
        System.out.println("Output:   " + new SolutionJava46().permute(nums));
        System.out.println("Expected: [[0,1],[1,0]]");

        // Example 3
        nums = new int[]{1};
        System.out.println("Input:    " + Arrays.toString(nums));
        System.out.println("Output:   " + new SolutionJava46().permute(nums));
        System.out.println("Expected: [[1]]");


    }
}
