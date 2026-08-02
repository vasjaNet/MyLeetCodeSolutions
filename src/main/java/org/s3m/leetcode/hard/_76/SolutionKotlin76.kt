package org.s3m.leetcode.hard._76

fun minWindow(s: String, t: String): String {
    var result = ""
    val sMap = IntArray(256)
    val tMap = IntArray(256)
    for(i in t.indices){
        tMap[t[i].code]++
    }
    var left = 0
    var right = 0
    var count = t.length
    while(right < s.length) {
        val c = s[right].code;
        if(++sMap[c] <= tMap[c]) {
            count--
        }
        while(count == 0) {
            if(result.isEmpty() || right - left + 1 < result.length) {
                result = s.substring(left, right + 1)
            }
            var d = s[left].code
            if(--sMap[d] < tMap[d]) {
                count++
            }
            left++
        }
        right++
    }

    return result
}