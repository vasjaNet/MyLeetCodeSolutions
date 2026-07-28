package org.s3m.leetcode.medium._6

fun convert(s: String, numRows: Int): String {
    if(numRows < 2) return s
    val midCount = numRows - 2
    var firstShift = midCount + numRows
    var secondShift = 0
    val sb = StringBuilder()
    for(i in 0 until numRows) {
        var j = i
        while(j < s.length) {
            if(firstShift != 0) {
                sb.append(s[j])
            }
            j+= firstShift
            if(j >= s.length) break;
            if(secondShift != 0) {
                sb.append(s[j])
            }
            j += secondShift;
        }
        firstShift -= 2
        secondShift += 2
    }
    return sb.toString()
}

fun main() {
    val s = "PAYPALISHIRING"
    val numRows = 3
    println(convert(s, numRows))

}