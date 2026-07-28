package org.s3m.leetcode.easy._28

fun strStr(haystack: String, needle: String): Int {
    if(haystack.length < needle.length) return -1
    var i = 0
    do {
        var isEqual = true
        for( j in needle.indices) {
            if(haystack[i+j] != needle[j]) {
                isEqual = false
                break
            }
        }
        if(isEqual) return i
        i++
    } while(i <= haystack.length - needle.length)
    return -1
}


fun main() {
    val haystack = "sadbutsad"
    val needle = "sad"
    println(strStr(haystack, needle))
}