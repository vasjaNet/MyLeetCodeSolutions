package org.s3m.leetcode.medium._55

fun canJump(nums: IntArray): Boolean {
    var maxJump = 0
    for(i in nums.indices) {
        if(i > maxJump) {
            return false
        }
        maxJump = maxOf(maxJump, i + nums[i])
    }
    return true
}

fun main() {
    val nums = intArrayOf(2,3,1,1,4)
    val result = canJump(nums)
    println(result)
}