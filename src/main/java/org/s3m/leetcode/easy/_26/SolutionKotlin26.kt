package org.s3m.leetcode.easy._26

fun removeDuplicates(nums: IntArray): Int {
    var shift = 0
    for((i, element) in nums.withIndex()) {
        if(shift > 0) {
            nums[i-shift] = element
        }
        if(i < nums.size-1 && element == nums[i+1]) {
            shift++
        }
    }

    return nums.size - shift
}

fun main() {
    val nums = intArrayOf(1,1,2)
    val result = removeDuplicates(nums)
    for (i in 0..<result) {
        print("${nums[i]} ")
    }
}