package org.s3m.leetcode.medium._77;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SolutionJava77 {

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
        System.out.println("Output:   " + new SolutionJava77().combine(n, k));
        System.out.println("Expected: [[1, 2], [1, 3], [1, 4], [2, 3], [2, 4], [3, 4]]");

        // Example 2
        n = 1;
        k = 1;
        System.out.println("Input:    " + n + ", " + k);
        System.out.println("Output:   " + new SolutionJava77().combine(n, k));
        System.out.println("Expected: [[1]]");

        // Example 4
        n = 5; k = 3;
        System.out.println("Input:    " + n + ", " + k);
        System.out.println("Output:   " + new SolutionJava77().combine(n, k));
        System.out.println("Expected: [[1, 2, 3], [1, 2, 4], [1, 2, 5], [1, 3, 4], [1, 3, 5], [1, 4, 5], [2, 3, 4], [2, 3, 5], [2, 4, 5], [3, 4, 5]]");


    }
}
