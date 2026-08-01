package org.s3m.leetcode.easy._125

fun isPalindrome(s: String): Boolean {
    val prityfy = s.lowercase().filter(){ it.isLetterOrDigit() }
    val n = prityfy.length
    if(n<2) return true
    val mid = n / 2
    var j = n - 1
    for(i in 0 .. mid) {
        if(prityfy[i] != prityfy[j]) {
            return false
        }
        j --
    }
    return true
}

fun main() {
    val s = "asdfdsa"
    println(isPalindrome(s))
}