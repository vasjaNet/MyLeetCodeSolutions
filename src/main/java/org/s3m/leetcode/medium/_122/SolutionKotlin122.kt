package org.s3m.leetcode.medium._122

fun maxProfit(prices: IntArray): Int {
    var sum = 0
    for(i in 1 until prices.size) {
        val tmp = prices[i] - prices[i-1]
        if(tmp>0) {
            sum+=tmp
        }
    }
    return sum
}

fun main() {
    val prices = intArrayOf(7,1,5,3,6,4)
    val result = maxProfit(prices)
    println(result)
}