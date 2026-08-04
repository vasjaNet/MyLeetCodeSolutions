package org.s3m.leetcode.medium._36

fun isValidSudoku(board: Array<CharArray>): Boolean {
    val rows = mutableMapOf<Int, MutableSet<Char>>()
    val columns = mutableMapOf<Int, MutableSet<Char>>()
    val boxes = mutableMapOf<Int, MutableSet<Char>>()

    for(i in 0..8) {
        val row = board[i]
        for(j in 0..8) {
            val c = row[j]
            if (c == '.') continue
            if(c in rows.getOrPut(i) { mutableSetOf() }) {
                return false
            } else {
                rows[i]?.add(c)
            }
            if(c in columns.getOrPut(j) { mutableSetOf() }) {
                return false
            } else {
                columns[j]?.add(c)
            }
            val boxIndex: Int = (i/3)*3 + j/3;
            if(c in boxes.getOrPut(boxIndex) { mutableSetOf() }) {
                return false
            } else {
                boxes[boxIndex]?.add(c)
            }

        }
    }
    return true
}