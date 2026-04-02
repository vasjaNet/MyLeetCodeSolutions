package org.s3m.leetcode.hard._42;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionJava42 {

    //todo: optimize do not use extra arrays
    public int trap(int[] height) {
        int result = 0;
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        left[0] = height[0];
        right[height.length - 1] = height[height.length - 1];
        for(int i = 1; i < height.length; i++) {
            left[i] = Math.max(left[i-1], height[i]);
            right[height.length - i - 1] = Math.max(right[height.length - i], height[height.length - i - 1]);
        }
        for(int i = 0; i < height.length; i++) {
            result += Math.min(left[i], right[i]) - height[i];
        }
        return result;
    }

    public static void main(String[] args) {

        // Example 1
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("Input:    " + height);
        System.out.println("Output:   " + new SolutionJava42().trap(height));
        System.out.println("Expected: 6");

        // Example 2
        height = new int[]{4,2,0,3,2,5};
        System.out.println("Input:    " + height);
        System.out.println("Output:   " + new SolutionJava42().trap(height));
        System.out.println("Expected: 9");


    }

}
