package org.s3m.leetcode.medium;


import java.util.*;

/**
 * Course Schedule II
 * <p>
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.
 * <p>
 * Example 1:
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
 * Example 2:
 * Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 * So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
 * Example 3:
 * Input: numCourses = 1, prerequisites = []
 * Output: [0]
 */
public class Solution210 {

    //todo: optimize use topological sort
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
        int[] result = new int[numCourses];
        int k = 0;
        for (int i = 0; i < numCourses; ++i) {
            if (indeg[i] == 0) {
                q.offer(i);
                result[k++] = i;
            }
        }
        while (!q.isEmpty()) {
            int i = q.poll();
            for (int j : g[i]) {
                if (--indeg[j] == 0) {
                    q.offer(j);
                    result[k++] = j;
                }
            }
            --numCourses;
        }
        return numCourses == 0 ? result : new int[] {};
    }

    public static void main(String[] args) {

        // Example 1
        int numCourses = 2;
        int[][] prerequisites = {{1,0}};
        System.out.println("Input:    " + numCourses + ", " + Arrays.deepToString(prerequisites));
        System.out.println("Output:   " + Arrays.toString(new Solution210().findOrder(numCourses, prerequisites)));
        System.out.println("Expected: [0,1]");

        // Example 2
        numCourses = 4;
        int[][]  prerequisites2 = {{1,0},{2,0},{3,1},{3,2}};
        System.out.println("Input:    " + numCourses + ", " + Arrays.deepToString(prerequisites2));
        System.out.println("Output:   " + Arrays.toString(new Solution210().findOrder(numCourses, prerequisites2)));
        System.out.println("Expected: [0,2,1,3]");

        // Example 3
        numCourses = 1;
        int[][]  prerequisites3 = new int[0][0];
        System.out.println("Input:    " + numCourses + ", " + Arrays.deepToString(prerequisites3));
        System.out.println("Output:   " + Arrays.toString(new Solution210().findOrder(numCourses, prerequisites3)));
        System.out.println("Expected: [0]");
    }
}
