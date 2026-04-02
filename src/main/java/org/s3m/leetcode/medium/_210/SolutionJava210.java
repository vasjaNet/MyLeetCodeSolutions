package org.s3m.leetcode.medium._210;


import java.util.*;

public class SolutionJava210 {

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
        System.out.println("Output:   " + Arrays.toString(new SolutionJava210().findOrder(numCourses, prerequisites)));
        System.out.println("Expected: [0,1]");

        // Example 2
        numCourses = 4;
        int[][]  prerequisites2 = {{1,0},{2,0},{3,1},{3,2}};
        System.out.println("Input:    " + numCourses + ", " + Arrays.deepToString(prerequisites2));
        System.out.println("Output:   " + Arrays.toString(new SolutionJava210().findOrder(numCourses, prerequisites2)));
        System.out.println("Expected: [0,2,1,3]");

        // Example 3
        numCourses = 1;
        int[][]  prerequisites3 = new int[0][0];
        System.out.println("Input:    " + numCourses + ", " + Arrays.deepToString(prerequisites3));
        System.out.println("Output:   " + Arrays.toString(new SolutionJava210().findOrder(numCourses, prerequisites3)));
        System.out.println("Expected: [0]");
    }
}
