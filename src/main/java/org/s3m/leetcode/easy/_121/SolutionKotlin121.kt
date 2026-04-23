package org.s3m.leetcode.easy._121

fun maxProfit(prices: IntArray): Int {
    var min = prices[0]
    var profit = 0
    for(i in 1 until prices.size) {
        min = minOf(min, prices[i])
        profit = maxOf(profit, prices[i] - min)
    }
    return profit
}

fun main() {
    val prices = intArrayOf(7,1,5,3,6,4)
    val result = maxProfit(prices)
    println(result)
}

