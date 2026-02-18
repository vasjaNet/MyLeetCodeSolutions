package org.s3m.leetcode.easy;


import java.util.Arrays;

/**
 * Merge Sorted Array
 * <p>
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 * <p>
 * Example 1:
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
 * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
 * Example 2:
 * Input: nums1 = [1], m = 1, nums2 = [], n = 0
 * Output: [1]
 * Explanation: The arrays we are merging are [1] and [].
 * The result of the merge is [1].
 * Example 3:
 * Input: nums1 = [0], m = 0, nums2 = [1], n = 1
 * Output: [1]
 * Explanation: The arrays we are merging are [] and [1].
 * The result of the merge is [1].
 * Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
 */
public class Solution88 {
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
        new Solution88().merge(nums1, m, nums2, n);
        System.out.println("Output:   " + Arrays.toString(nums1));
        System.out.println("Expected: [1,2,2,3,5,6]");

        // Example 2
        nums1 = new int[]{1};
        m = 1;
        nums2 = new int[]{};
        n = 0;
        System.out.println("Input:    " + Arrays.toString(nums1));
        new Solution88().merge(nums1, m, nums2, n);
        System.out.println("Output:   " + Arrays.toString(nums1));
        System.out.println("Expected: [1]");

        // Example 3
        nums1 = new int[]{0};
        m = 0;
        nums2 = new int[]{1};
        n = 1;
        System.out.println("Input:    " + Arrays.toString(nums1));
        new Solution88().merge(nums1, m, nums2, n);
        System.out.println("Output:   " + Arrays.toString(nums1));
        System.out.println("Expected: [1]");

        // Example 4
        nums1 = new int[]{4,5,6,0,0,0};
        m = 3;
        nums2 = new int[]{1,2,3};
        n = 3;
        System.out.println("Input:    " + Arrays.toString(nums1));
        new Solution88().merge(nums1, m, nums2, n);
        System.out.println("Output:   " + Arrays.toString(nums1));
        System.out.println("Expected: [1,2,3,4,5,6]");

    }
}
