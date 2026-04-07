package org.s3m.leetcode.hard._4;



import java.util.Arrays;

public class SolutionJava4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int totalLength = m + n;
        int mid = totalLength / 2;
        int k = 0;
        int mIndex = 0;
        int nIndex = 0;
        int previous = 0;
        int current = 0;
        do {
            previous = current;
            if(nIndex >= n || (mIndex < m && nums1[mIndex] < nums2[nIndex])) {
                current = nums1[mIndex];
                mIndex++;
            } else {
                current = nums2[nIndex];
                nIndex++;
            }
            k++;
        } while(k <= mid);
        if(totalLength % 2 == 0) {
            return (previous + current) / 2.0;
        } else {
            return current;
        }
    }

    public static void main(String[] args) {

        // Example 1
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        System.out.println("Input:    " + Arrays.toString(nums1) + ", " + Arrays.toString(nums2));
        System.out.println("Output:   " + new SolutionJava4().findMedianSortedArrays(nums1, nums2));
        System.out.println("Expected: 2.5");

        // Example 2
        nums1 = new int[]{1,3};
        nums2 = new int[]{2};
        System.out.println("Input:    " + Arrays.toString(nums1) + ", " + Arrays.toString(nums2));
        System.out.println("Output:   " + new SolutionJava4().findMedianSortedArrays(nums1, nums2));
        System.out.println("Expected: 2");
    }

}
