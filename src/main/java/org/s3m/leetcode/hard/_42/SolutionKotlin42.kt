package org.s3m.leetcode.hard._42

import kotlin.math.max
import kotlin.math.min

fun trap(height: IntArray): Int {
    val n = height.size
    val left = IntArray(n)
    val right = IntArray(n)
    left[0] = height[0]
    right[n-1] = height[n-1]
    var ri = n-2
    for(i in 1..<n) {
        left[i] = max(left[i-1], height[i])
        right[ri] = max(right[ri+1], height[ri])
        ri--
    }
    var result = 0
    for(i in 0..<n) {
        result += min(left[i], right[i]) - height[i]
    }
    return result

}

fun main() {
    val h = intArrayOf(0,1,0,2,1,0,1,3,2,1,2,1)
    println(trap(h))
}