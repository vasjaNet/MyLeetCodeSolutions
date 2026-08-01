package org.s3m.leetcode.medium._11

fun maxArea(height: IntArray): Int {
    var dist = height.size -1
    var l = 0
    var r = dist
    var max = 0
    do {
        val lh = height[l]
        val rh = height[r]
        val h = if(lh < rh) lh else rh
        max = if(h*dist > max) h*dist else max
        if(lh > rh) {
            r--
        } else {
            l++
        }
        dist --

    } while(l<r)
    return max
}