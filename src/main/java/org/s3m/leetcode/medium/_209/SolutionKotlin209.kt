package org.s3m.leetcode.medium._209

import kotlin.math.min

fun minSubArrayLen(target: Int, nums: IntArray): Int {
    var minSize = Int.MAX_VALUE
    var j = 0
    var size = 0
    var sum = 0
    for(i in nums.indices) {
        sum += nums[i]
        size ++
        while(sum >= target) {
            minSize = min(size, minSize)
            sum-= nums[j]
            size--
            j++
        }
    }

    return if(minSize == Int.MAX_VALUE) 0 else minSize
}