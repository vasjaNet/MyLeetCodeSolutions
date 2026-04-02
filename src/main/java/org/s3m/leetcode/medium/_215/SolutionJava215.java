package org.s3m.leetcode.medium._215;


import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class SolutionJava215 {

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
        System.out.println("Output:   " + new SolutionJava215().findKthLargest(nums, k));
        System.out.println("Expected: 5");

        // Example 2
        nums = new int[]{3,2,3,1,2,4,5,5,6};
        k = 4;
        System.out.println("Input:    " + Arrays.toString(nums) + ", " + k);
        System.out.println("Output:   " + new SolutionJava215().findKthLargest(nums, k));
        System.out.println("Expected: 4");

    }
}
