package org.s3m.leetcode.medium;


import java.util.*;

/**
 * Course Schedule
 * <p>
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 * <p>
 * Example 1:
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 * Example 2:
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 */
public class Solution207 {

    //todo: optimize use topological sort
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] g = new List[numCourses];
        Arrays.setAll(g, k -> new ArrayList<>());
        int[] indeg = new int[numCourses];
        for (var p : prerequisites) {
            int a = p[0];
            int b = p[1];
            g[b].add(a);
            ++indeg[a];
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; ++i) {
            if (indeg[i] == 0) q.offer(i);
        }
        while (!q.isEmpty()) {
            int i = q.poll();
            for (int j : g[i]) {
                if (--indeg[j] == 0) q.offer(j);
            }
            --numCourses;
        }
        return numCourses == 0;
    }

    public static void main(String[] args) {

        // Example 1
        int numCourses = 2;
        int[][] prerequisites = {{1,0}};
        System.out.println("Input:    " + numCourses + ", " + Arrays.deepToString(prerequisites));
        System.out.println("Output:   " + new Solution207().canFinish(numCourses, prerequisites));
        System.out.println("Expected: true");

        // Example 2
        int[][]  prerequisites2 = {{1, 0},{0, 1}};
        System.out.println("Input:    " + numCourses + ", " + Arrays.deepToString(prerequisites2));
        System.out.println("Output:   " + new Solution207().canFinish(numCourses, prerequisites2));
        System.out.println("Expected: false");


    }
}
