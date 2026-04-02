package org.s3m.leetcode.easy._88;


import java.util.Arrays;

public class SolutionJava88 {
    //todo: optimize  (by merging from the end of the array)
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int endIndex = m-1;
        int mIndex = 0;
        int nIndex = 0;

        while(nIndex < n) {
            int mergeElem = nums2[nIndex];
            if(mIndex <= endIndex) {
                int current = nums1[mIndex];

                if(mergeElem < current) {
                    endIndex++;
                    for(int j = endIndex; j > mIndex; j--) {
                        nums1[j] = nums1[j-1];
                    }
                    nums1[mIndex] = mergeElem;
                    nIndex++;
                }
            } else {
                nums1[mIndex] = mergeElem;
                nIndex++;
            }
            mIndex++;
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
