package org.s3m.leetcode.medium._151

fun reverseWords(s: String): String {
    val words = s.split(" ")
    val sb = StringBuilder()
    for(i in words.indices.reversed()) {
        if(words[i].isEmpty()) continue
        sb.append(words[i])
        sb.append(" ")
    }
    sb.deleteCharAt(sb.length - 1)
    return sb.toString()
}