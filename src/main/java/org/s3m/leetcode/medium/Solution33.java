package org.s3m.leetcode.medium;


/**
 * Search in Rotated Sorted Array
 * <p>
 * There is an integer array nums sorted in ascending order (with distinct values).
 * Prior to being passed to your function, nums is possibly left rotated at an unknown index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be left rotated by 3 indices and become [4,5,6,7,0,1,2].
 * Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
 * You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * Example 1:
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * Example 3:
 * Input: nums = [1], target = 0
 * Output: -1
 */
public class Solution33 {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }



    public static void main(String[] args) {

        // Example 1
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println("Input:    " + nums + ", " + target);
        System.out.println("Output:   " + new Solution33().search(nums, target));
        System.out.println("Expected: 4");

        // Example 2
        nums = new int[]{4,5,6,7,0,1,2};
        target = 3;
        System.out.println("Input:    " + nums + ", " + target);
        System.out.println("Output:   " + new Solution33().search(nums, target));
        System.out.println("Expected: -1");

        // Example 3
        nums = new int[]{1};
        target = 0;
        System.out.println("Input:    " + nums + ", " + target);
        System.out.println("Output:   " + new Solution33().search(nums, target));
        System.out.println("Expected: -1");

        // Example 4
        nums = new int[]{5,1,3};
        target = 5;
        System.out.println("Input:    " + nums + ", " + target);
        System.out.println("Output:   " + new Solution33().search(nums, target));
        System.out.println("Expected: 0");

        // Example 5
        nums = new int[]{4,5,6,7,8,1,2,3};
        target = 8;
        System.out.println("Input:    " + nums + ", " + target);
        System.out.println("Output:   " + new Solution33().search(nums, target));
        System.out.println("Expected: 4");



    }
}
