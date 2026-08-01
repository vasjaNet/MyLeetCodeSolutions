package org.s3m.leetcode.medium._167

fun twoSum(numbers: IntArray, target: Int): IntArray {
    var l = 0
    var r = numbers.size -1
    while(l<r) {
        val sum = numbers[l] + numbers[r]
        when{
            sum == target -> break
            sum > target -> r--
            else -> l++
        }
    }
    return intArrayOf(l+1, r+1)
}

fun main() {
    val numbers = intArrayOf(2,7,11,15)
    val target = 9
    println(twoSum(numbers, target))
}