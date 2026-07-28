package org.s3m.leetcode.easy._14

fun longestCommonPrefix(strs: Array<String>): String {
    var result: String = ""
    var isEqual = true
    for(i in 0..strs[0].length-1){
        val c = strs[0][i]
        for(str in strs) {
            if(str.length < i+1 || c != str[i]) {
                isEqual = false
                break
            }
        }
        if(isEqual) {
            result += c
        }  else {
            break
        }
    }
    return result
}

fun main() {
    var strs = arrayOf("flower","flow","flight")
    println(longestCommonPrefix(strs))
}