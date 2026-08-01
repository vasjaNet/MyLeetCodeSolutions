package org.s3m.leetcode.easy._392

fun isSubsequence(s: String, t: String): Boolean {
    if(t.length < s.length) return false
    if(s.length == 0) return true
    var si = 0
    for(ti in t.indices) {
        if(t[ti] == s[si]) {
            si++
        }
        if(si == s.length) return true
    }
    return false
}

fun main() {
    val s = "abc"
    val t = "ahbgdc"

    println(isSubsequence(s, t))
}