package org.s3m.leetcode.medium._189

fun rotate(nums: IntArray, k: Int): Unit {
    val n: Int = nums.size
    val shift = k % n
    nums.reverse(0, n)
    nums.reverse(0, shift)
    nums.reverse(shift, n)
}


fun main() {
    val nums = intArrayOf(1,2,3,4,5,6,7)
    val k = 3
    rotate(nums, k)
    for (i in nums) {
        print("$i ")
    }
}


