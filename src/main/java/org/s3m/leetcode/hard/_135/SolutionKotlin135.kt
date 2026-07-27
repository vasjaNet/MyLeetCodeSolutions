package org.s3m.leetcode.hard._135

import java.lang.Integer.max

fun candy(ratings: IntArray): Int {
    val n = ratings.size
    val left = IntArray(n)
    left[0] = 1
    val right = IntArray(n)
    right[n-1] = 1
    var j = n-2;
    for(i in 1..<n) {
        left[i] =  if(ratings[i] > ratings[i-1])  left[i-1] + 1 else 1
        right[j] = if(ratings[j] > ratings[j+1]) right[j+1] + 1 else  1
        j--
    }


    var result = 0
    for(i in 0..<n) {
        result+= max(left[i],right[i])
    }
    return result;
}

fun main() {

    val ratings = intArrayOf(1,0,2)
    val res = candy(ratings)
    println(res)
}