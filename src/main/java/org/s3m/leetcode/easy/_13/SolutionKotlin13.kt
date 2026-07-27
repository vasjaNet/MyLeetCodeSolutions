package org.s3m.leetcode.easy._13

val map = mapOf(
    'I' to 1,
    'V' to 5,
    'X' to 10,
    'L' to 50,
    'C' to 100,
    'D' to 500,
    'M' to 1000)
fun romanToInt(s: String): Int {
    var result = 0
    val n = s.length
    for(i in 0..n-2) {
        val c = map[s[i]] ?: 0
        val next = map[s[i+1]] ?: 0
        if(c < next) {
            result -= c
        } else {
            result += c
        }
    }
    result += map[s[n-1]] ?: 0
    return result
}

fun main() {
    val s = "LVIII"
    val t = romanToInt(s)
    println(t)
}