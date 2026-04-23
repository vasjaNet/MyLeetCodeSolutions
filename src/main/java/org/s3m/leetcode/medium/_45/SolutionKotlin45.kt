package org.s3m.leetcode.medium._45

fun jump(nums: IntArray): Int {
    var result = 0
    var maxReach = 0
    var current = 0
    for(i in 0 until nums.lastIndex) {
        maxReach = maxOf(maxReach, i + nums[i])
        if(i == current) {
            result++
            current = maxReach
            if(current >= nums.lastIndex) {
                return result
            }
        }
    }
    return result
}

fun main() {
    val nums = intArrayOf(2,3,1,1,4)
    val result = jump(nums)
    println(result)
}