package org.s3m.leetcode.medium._73

fun setZeroes(matrix: Array<IntArray>): Unit {
    val xCol = IntArray(matrix[0].size) {1}
    for(i in 0 until matrix.size) {
        var isRowZero = false
        var col = matrix[i]
        for(j in 0 until col.size ){
            if(col[j] == 0) {
                isRowZero = true
                xCol[j] = 0
                for(k in 0 until j) {
                    col[k] = 0
                }
                for(k in 0 until i) {
                    matrix[k][j] = 0;
                }
            } else if(isRowZero || xCol[j] == 0) {
                col[j] = 0
            }
        }
    }

}