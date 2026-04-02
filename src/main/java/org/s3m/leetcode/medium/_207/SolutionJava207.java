package org.s3m.leetcode.medium._207;


import java.util.*;

public class SolutionJava207 {

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
        System.out.println("Output:   " + new SolutionJava207().canFinish(numCourses, prerequisites));
        System.out.println("Expected: true");

        // Example 2
        int[][]  prerequisites2 = {{1, 0},{0, 1}};
        System.out.println("Input:    " + numCourses + ", " + Arrays.deepToString(prerequisites2));
        System.out.println("Output:   " + new SolutionJava207().canFinish(numCourses, prerequisites2));
        System.out.println("Expected: false");


    }
}
