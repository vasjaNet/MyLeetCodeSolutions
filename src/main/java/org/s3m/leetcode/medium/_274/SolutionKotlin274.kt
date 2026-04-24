package org.s3m.leetcode.medium._274

fun hIndex(citations: IntArray): Int {
    val n = citations.size
    val dp = IntArray(n+1)
    for(i in citations.indices) {
        dp[minOf(n, citations[i])]++
    }
    var count = 0

    for(i in n downTo 0) {
        count += dp[i]
        if(count >= i) {
            return i
        }
    }
    return 0
}

fun main() {
    val citations = intArrayOf(3,0,6,1,5)
    val result = hIndex(citations)
    println(result)
}