package org.s3m.leetcode.medium._452;


import java.util.*;

public class SolutionJava452 {

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> (a[1] <= b[1]) ? -1 : 1);
        int count = 0;
        long end = -(1L << 60);
        for(int[] point : points) {
            if(point[0] > end) {
                count++;
                end = point[1];
            }
        }
        return count;
    }



    public static void main(String[] args) {

        // Example 1
        int[][] points = {{10,16},{2,8},{1,6},{7,12}};
        System.out.println("Input:    " + Arrays.deepToString(points));
        System.out.println("Output:   " + new SolutionJava452().findMinArrowShots(points));
        System.out.println("Expected: 2");

        // Example 2
        int[][] points2 = {{1,2},{3,4},{5,6},{7,8}};
        System.out.println("Input:    " + Arrays.deepToString(points2));
        System.out.println("Output:   " + new SolutionJava452().findMinArrowShots(points2));
        System.out.println("Expected: 4");

        // Example 3
        int[][] points3 = {{-2147483646,-2147483645},{2147483646,2147483647}};
        System.out.println("Input:    " + Arrays.deepToString(points3));
        System.out.println("Output:   " + new SolutionJava452().findMinArrowShots(points3));
        System.out.println("Expected: 2 ");



    }
}
