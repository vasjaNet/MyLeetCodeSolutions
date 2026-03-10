package org.s3m.leetcode.medium;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Combinations
 * <p>
 * Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
 * You may return the answer in any order.
 * <p>
 * Example 1:
 * Input: n = 4, k = 2
 * Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
 * Explanation: There are 4 choose 2 = 6 total combinations.
 * Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
 * Example 2:
 * Input: n = 1, k = 1
 * Output: [[1]]
 * Explanation: There is 1 choose 1 = 1 total combination.
 */
public class Solution77 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();
        combine(1, n, k, new ArrayList<>(), result);
        return result;
    }

    private void combine(int start, int n, int k, List<Integer> list, List<List<Integer>> result) {
        if(0 == k) {
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i = start; i <= n; i++) {
            list.add(i);
            combine(i+1, n, k-1, list, result);
            list.removeLast();
        }
    }



    public static void main(String[] args) {

        // Example 1
        int n = 4, k = 2;
        System.out.println("Input:    " + n + ", " + k);
        System.out.println("Output:   " + new Solution77().combine(n, k));
        System.out.println("Expected: [[1, 2], [1, 3], [1, 4], [2, 3], [2, 4], [3, 4]]");

        // Example 2
        n = 1;
        k = 1;
        System.out.println("Input:    " + n + ", " + k);
        System.out.println("Output:   " + new Solution77().combine(n, k));
        System.out.println("Expected: [[1]]");

        // Example 4
        n = 5; k = 3;
        System.out.println("Input:    " + n + ", " + k);
        System.out.println("Output:   " + new Solution77().combine(n, k));
        System.out.println("Expected: [[1, 2, 3], [1, 2, 4], [1, 2, 5], [1, 3, 4], [1, 3, 5], [1, 4, 5], [2, 3, 4], [2, 3, 5], [2, 4, 5], [3, 4, 5]]");


    }
}
