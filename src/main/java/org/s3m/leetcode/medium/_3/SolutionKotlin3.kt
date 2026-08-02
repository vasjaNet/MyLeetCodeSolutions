package org.s3m.leetcode.medium._3

import kotlin.math.max

fun lengthOfLongestSubstring(s: String): Int {
    var l = 0
    var r = 0
    var maxLength = 0
    val set = HashSet<Char>()
    while(r < s.length) {
        if(set.contains(s[r])) {
            set.remove(s[l++])
        } else {
            set.add(s[r])
            maxLength = max(maxLength, r - l + 1)
            r++
        }
    }
    return maxLength
}