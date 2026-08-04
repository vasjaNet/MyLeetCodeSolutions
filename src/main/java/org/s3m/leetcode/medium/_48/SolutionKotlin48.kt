package org.s3m.leetcode.medium._48

fun rotate(matrix: Array<IntArray>): Unit {
    for(k in 0 until (matrix.size / 2)) {
        val i = 0 + k
        val j = (matrix.size-1) - k

        for(s in 0 until j-i) {
            val lt = matrix[i][i+s]
            matrix[i][i+s] = matrix[j-s][i]
            matrix[j-s][i] = matrix[j][j-s]
            matrix[j][j-s] = matrix[i+s][j]
            matrix[i+s][j] = lt
        }
    }
}