package org.s3m.leetcode.medium._12

var map = mapOf(
    1000 to "M",
    900 to "CM",
    500 to "D",
    400 to "CD",
    100 to "C",
    90 to "XC",
    50 to "L",
    40 to "XL",
    10 to "X",
    9 to "IX",
    5 to "V",
    4 to "IV",
    1 to "I")

fun intToRoman(num: Int): String {
    var result = ""
    var numCopy = num

    map.forEach { (k,v) ->
        while(numCopy >= k) {
            result += v
            numCopy -= k
        }
    }

    return result

}

fun main() {
    val num = 3749
    println(intToRoman(num))
}