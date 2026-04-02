package org.s3m.leetcode.easy._27


fun main() {
    val nums = intArrayOf(3, 2, 2, 3)
    val result = removeElement(nums, 3)
    for (i in 0..<result) {
        print("${nums[i]} ")
    }
}

fun removeElement(nums: IntArray, `val`: Int): Int {
    var shift = 0;
    for(i in nums.indices) {
        if(shift > 0) {
            nums[i-shift] = nums[i]
        }
        if(nums[i] == `val`) {
            shift++
        }
    }

    return nums.size - shift;
}