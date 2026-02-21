package org.s3m.leetcode.medium;


import java.util.Arrays;

/**
 * Insert Interval
 * <p>
 * You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
 * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
 * Return intervals after the insertion.
 * Note that you don't need to modify intervals in-place. You can make a new array and return it.
 * <p>
 * Example 1:
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * Example 2:
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 */
public class Solution57 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int ip = -1;
        int jp = n;
        int mergeCount = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][1] < newInterval[0]) {
                ip = i;
            } else if (intervals[i][0] > newInterval[1]) {
                jp = i;
                break;
            } else {
                newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
                mergeCount++;
            }
        }
        int rn = n + 1 - mergeCount;
        int[][] result = new int[rn][2];

        System.arraycopy(intervals, 0, result, 0, ip+1);
        result[ip+1] = newInterval;
        System.arraycopy(intervals, jp, result, ip+2, n-jp);

        return result;
    }

    public static void main(String[] args) {

        // Example 11
        int[][] intervals = {{4,5},{8,9}};
        int[] newInterval = {1,2};
        System.out.println("Input:    " + Arrays.deepToString(intervals));
        System.out.println("newInterval:   " + Arrays.toString(newInterval));
        System.out.println("Output:   " + Arrays.deepToString(new Solution57().insert(intervals, newInterval)));
        System.out.println("Expected: [[1, 2], [4, 5], [8, 9]]");

        // Example 12
        intervals = new int[][]{{1,3},{6,9}};
        newInterval = new int[]{11,12};
        System.out.println("Input:    " + Arrays.deepToString(intervals));
        System.out.println("newInterval:   " + Arrays.toString(newInterval));
        System.out.println("Output:   " + Arrays.deepToString(new Solution57().insert(intervals, newInterval)));
        System.out.println("Expected: [[1, 3], [6, 9], [11, 12]]");


        // Example 1
        intervals = new int[][]{{1,3},{6,9}};
        newInterval = new int[]{2,5};
        System.out.println("Input:    " + Arrays.deepToString(intervals));
        System.out.println("newInterval:   " + Arrays.toString(newInterval));
        System.out.println("Output:   " + Arrays.deepToString(new Solution57().insert(intervals, newInterval)));
        System.out.println("Expected: [[1, 5], [6, 9]]");

        // Example 2
        intervals = new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}};
        newInterval = new int[]{4,8};
        System.out.println("Input:    " + Arrays.deepToString(intervals));
        System.out.println("newInterval:   " + Arrays.toString(newInterval));
        System.out.println("Output:   " + Arrays.deepToString(new Solution57().insert(intervals, newInterval)));
        System.out.println("Expected: [[1, 2], [3, 10], [12, 16]]");

        // Example 3
        intervals = new int[][]{{1,2},{8,10},{12,16}};
        newInterval = new int[]{4,6};
        System.out.println("Input:    " + Arrays.deepToString(intervals));
        System.out.println("newInterval:   " + Arrays.toString(newInterval));
        System.out.println("Output:   " + Arrays.deepToString(new Solution57().insert(intervals, newInterval)));
        System.out.println("Expected: [[1, 2], [4, 6], [8, 10], [12, 16]]");
    }
}
