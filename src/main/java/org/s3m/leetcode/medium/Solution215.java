package org.s3m.leetcode.medium;


import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Kth Largest Element in an Array
 * <p>
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * Can you solve it without sorting?
 * <p>
 * Example 1:
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 * Example 2:
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 * Output: 4
 */
public class Solution215 {

    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        for(int num : nums) {
            queue.offer(num);
            if(queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }
/*
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
*/


    public static void main(String[] args) {

        // Example 1
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println("Input:    " + Arrays.toString(nums) + ", " + k);
        System.out.println("Output:   " + new Solution215().findKthLargest(nums, k));
        System.out.println("Expected: 5");

        // Example 2
        nums = new int[]{3,2,3,1,2,4,5,5,6};
        k = 4;
        System.out.println("Input:    " + Arrays.toString(nums) + ", " + k);
        System.out.println("Output:   " + new Solution215().findKthLargest(nums, k));
        System.out.println("Expected: 4");

    }
}
