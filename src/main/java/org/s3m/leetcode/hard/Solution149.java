package org.s3m.leetcode.hard;

import java.util.*;

/**
 * Max Points on a Line
 * <p>
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane, return the maximum number of points that lie on the same straight line.
 * </p>
 * Example 1:
 * Input: points = [[1,1],[2,2],[3,3]]
 * Output: 3
 * Example 2:
 * Input: points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * Output: 4
 */
public class Solution149 {

    public int maxPoints(int[][] points) {
        int n = points.length;
        if(n < 3) return n;
        int maxCount = 2;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j <n; j++) {
                int[] p1, p2;
                int tmpCount = 2;
                p1 = points[j];
                p2 = points[i];
                if (p1[1] == p2[1]) {
                    for(int k = j + 1; k < n; k++) {
                        int[] p3 = points[k];
                        if(p1[1] == p3[1]) {
                            tmpCount++;
                        }
                    }
                    maxCount = Math.max(maxCount, tmpCount);
                } else if (p1[0] == p2[0]) {
                    for(int k = j + 1; k < n; k++) {
                        int[] p3 = points[k];
                        if(p1[0] == p3[0]) {
                            tmpCount++;
                        }
                    }
                    maxCount = Math.max(maxCount, tmpCount);
                } else {
                    int a = p2[1] - p1[1];
                    int b = p2[0] - p1[0];
                    for(int k = j + 1; k < n; k++) {
                        int[] p3 = points[k];
                        int x = a * (p3[0] - p1[0]);
                        int y = (p3[1] - p1[1]) * b;
                        if(x==y) {
                            tmpCount++;
                        }
                    }
                    maxCount = Math.max(maxCount, tmpCount);
                }
            }
            if(n-maxCount < i) {
                return maxCount;
            }
        }
        return maxCount;
    }


    public static void main(String[] args) {

        // Example 1
        int[][] points = {{1,1},{2,2},{3,3}};
        System.out.println("Input:    " + Arrays.toString(points));
        System.out.println("Output:   " + new Solution149().maxPoints(points));
        System.out.println("Expected: 3");

        // Example 2
        points = new int[][]{{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
        System.out.println("Input:    " + Arrays.toString(points));
        System.out.println("Output:   " + new Solution149().maxPoints(points));
        System.out.println("Expected: 4");

        // Example 3 [-6,-1],[3,1],[12,3]
        points = new int[][]{{-6,-1},{3,1},{12,3}};
        System.out.println("Input:    " + Arrays.toString(points));
        System.out.println("Output:   " + new Solution149().maxPoints(points));
        System.out.println("Expected: 3");

    }
}
