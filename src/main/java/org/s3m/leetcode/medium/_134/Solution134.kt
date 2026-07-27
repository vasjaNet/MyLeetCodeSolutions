package org.s3m.leetcode.medium._134

import java.sql.DriverManager.println

fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
    var debpt = 0
    var tank = 0
    var result = 0
    for (t in 0 .. gas.size-1) {
        tank += gas[t] - cost[t]
        if(tank < 0) {
            debpt += tank
            tank = 0
            result = t + 1
        }
    }
    debpt += tank
    return if(debpt >= 0) result else -1
}

fun main() {
    val gas = intArrayOf(1,2,3,4,5)
    val cost = intArrayOf(3,4,5,1,2)
    val result = canCompleteCircuit(gas, cost)
    println(result.toString())
}