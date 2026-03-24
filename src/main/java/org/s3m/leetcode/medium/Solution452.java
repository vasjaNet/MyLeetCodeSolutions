package org.s3m.leetcode.medium;


import java.util.*;

/**
 * Minimum Number of Arrows to Burst Balloons
 * <p>
 * There are some spherical balloons taped onto a flat wall that represents the XY-plane. The balloons are represented as a 2D integer array points where points[i] = [xstart, xend] denotes a balloon whose horizontal diameter stretches between xstart and xend. You do not know the exact y-coordinates of the balloons.
 * Arrows can be shot up directly vertically (in the positive y-direction) from different points along the x-axis. A balloon with xstart and xend is burst by an arrow shot at x if xstart <= x <= xend. There is no limit to the number of arrows that can be shot. A shot arrow keeps traveling up infinitely, bursting any balloons in its path.
 * Given the array points, return the minimum number of arrows that must be shot to burst all balloons.
 * <p>
 * Example 1:
 * Input: points = [[10,16],[2,8],[1,6],[7,12]]
 * Output: 2
 * Explanation: The balloons can be burst by 2 arrows:
 * - Shoot an arrow at x = 6, bursting the balloons [2,8] and [1,6].
 * - Shoot an arrow at x = 11, bursting the balloons [10,16] and [7,12].
 * Example 2:
 * Input: points = [[1,2],[3,4],[5,6],[7,8]]
 * Output: 4
 * Explanation: One arrow needs to be shot for each balloon for a total of 4 arrows.
 */
public class Solution452 {

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
        System.out.println("Output:   " + new Solution452().findMinArrowShots(points));
        System.out.println("Expected: 2");

        // Example 2
        int[][] points2 = {{1,2},{3,4},{5,6},{7,8}};
        System.out.println("Input:    " + Arrays.deepToString(points2));
        System.out.println("Output:   " + new Solution452().findMinArrowShots(points2));
        System.out.println("Expected: 4");

        // Example 3
        int[][] points3 = {{-2147483646,-2147483645},{2147483646,2147483647}};
        System.out.println("Input:    " + Arrays.deepToString(points3));
        System.out.println("Output:   " + new Solution452().findMinArrowShots(points3));
        System.out.println("Expected: 2 ");



    }
}
