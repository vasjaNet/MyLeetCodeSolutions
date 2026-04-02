package org.s3m.leetcode.medium._11;


import java.util.Arrays;

public class SolutionJava11 {

    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int max = 0;
        do {
            int lVal = height[l];
            int rVal = height[r];
            int actHeight = Math.min(lVal, rVal);
            int distance = r-l;
            int curVal = distance * actHeight;
            if(max < curVal) {
                max = curVal;
            }
            //todo: improvement  if next val is smaller we can move pointer faster
            if(lVal > rVal) {
                r--;
            } else {
                l++;
            }

        } while(l < r);


        return max;
    }

    public static void main(String[] args) {
        // Example 1
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println("Input:    " + Arrays.toString(height));
        System.out.println("Output:   " + new SolutionJava11().maxArea(height));
        System.out.println("Expected: 49");

        // Example 2
        height = new int[]{1,1};
        System.out.println("Input:    " + Arrays.toString(height));
        System.out.println("Output:   " + new SolutionJava11().maxArea(height));
        System.out.println("Expected: 1");

    }
}
