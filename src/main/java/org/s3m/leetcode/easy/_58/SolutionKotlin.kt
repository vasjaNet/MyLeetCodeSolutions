package org.s3m.leetcode.easy._58

fun lengthOfLastWord(s: String): Int {
    val n = s.length
    var lsc = -1
    var lcc = 0
    for(i in n-1 downTo 0) {
        val c = s[i]
        if(lcc == 0 &&  c != ' ') {
            lcc = i
        }
        if(lcc != 0 && c == ' ') {
            lsc = i
            break
        }
    }

    return lcc -lsc
}