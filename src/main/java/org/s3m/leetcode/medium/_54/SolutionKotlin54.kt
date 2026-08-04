package org.s3m.leetcode.medium._54

fun spiralOrder(matrix: Array<IntArray>): List<Int> {
    val m = matrix.size
    val n = matrix[0].size
    val result = mutableListOf<Int>()
    if(m==1) {
        for(i in 0 until n) {
            result.add(matrix[0][i])
        }
        return result
    }
    if(n==1) {
        for (j in 0 until m) {
            result.add(matrix[j][0])
        }
        return result
    }

    var j = 0
    var i = 0
    var maxi = n-1
    var mini = 0
    var maxj = m-1
    var minj = 0
    while(mini <= maxi || minj <= maxj) {
        if(m*n == result.size) return result
        while(i <= maxi) {
            result.add(matrix[j][i++])
        }
        minj++
        i--
        j++
        if(m*n == result.size) return result
        while(j <= maxj) {
            result.add(matrix[j++][i]);
        }
        i--
        j--
        maxi--
        if(m*n == result.size) return result
        while(i >= mini) {
            result.add(matrix[j][i--])
        }
        j--
        i++
        maxj--
        if(m*n == result.size) return result
        while ( j >= minj) {
            result.add(matrix[j--][i])
        }
        if(m*n == result.size) return result
        mini++
        i++
        j++
        if(mini == maxi && minj == maxj) {
            result.add(matrix[j][i])
            break
        }
    }
    return result
}