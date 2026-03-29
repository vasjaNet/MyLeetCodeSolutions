package org.s3m.leetcode.easy._27


fun main() {
    val nums = intArrayOf(3, 2, 2, 3)
    val result = removeElement(nums, 3)
    for (i in 0..<result) {
        print("${nums[i]} ")
    }
}

fun removeElement(nums: IntArray, `val`: Int): Int {
    var k = 0
    for (i in nums.indices) {
        if (nums[i] != `val`) {
            nums[k] = nums[i]
            k++
        }
    }
    return k
}