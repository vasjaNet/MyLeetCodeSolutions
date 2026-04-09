package org.s3m.leetcode.easy._88;


import java.util.Arrays;

public class SolutionJava88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int index = nums1.length-1;
        int mIndex = m-1;
        int nIndex = n-1;
        if(n == 0) return;
        while(index >= 0) {
            if(mIndex >=0 && nums1[mIndex] > nums2[nIndex]) {
                nums1[index] = nums1[mIndex];
                mIndex--;
            } else {
                nums1[index] = nums2[nIndex];
                nIndex--;
                if(nIndex < 0) return;
            }
            index--;
        }
    }

    public static void main(String[] args) {
        // Example 1
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        System.out.println("Input:    " + Arrays.toString(nums1));
        new SolutionJava88().merge(nums1, m, nums2, n);
        System.out.println("Output:   " + Arrays.toString(nums1));
        System.out.println("Expected: [1,2,2,3,5,6]");

        // Example 2
        nums1 = new int[]{1};
        m = 1;
        nums2 = new int[]{};
        n = 0;
        System.out.println("Input:    " + Arrays.toString(nums1));
        new SolutionJava88().merge(nums1, m, nums2, n);
        System.out.println("Output:   " + Arrays.toString(nums1));
        System.out.println("Expected: [1]");

        // Example 3
        nums1 = new int[]{0};
        m = 0;
        nums2 = new int[]{1};
        n = 1;
        System.out.println("Input:    " + Arrays.toString(nums1));
        new SolutionJava88().merge(nums1, m, nums2, n);
        System.out.println("Output:   " + Arrays.toString(nums1));
        System.out.println("Expected: [1]");

        // Example 4
        nums1 = new int[]{4,5,6,0,0,0};
        m = 3;
        nums2 = new int[]{1,2,3};
        n = 3;
        System.out.println("Input:    " + Arrays.toString(nums1));
        new SolutionJava88().merge(nums1, m, nums2, n);
        System.out.println("Output:   " + Arrays.toString(nums1));
        System.out.println("Expected: [1,2,3,4,5,6]");

    }
}
