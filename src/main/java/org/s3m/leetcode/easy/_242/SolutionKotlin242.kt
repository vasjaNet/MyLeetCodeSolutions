package org.s3m.leetcode.easy._242

fun isAnagram(s: String, t: String): Boolean {
    val letters = IntArray(26)
    for(i in 0 until s.length) {
        val index = s[i] - 'a'
        letters[index]++
    }
    for(j in 0 until t.length) {
        val index = t[j] - 'a'
        if(letters[index] == 0) return false
        --letters[index]
    }

    for(i in 0 until letters.size) {
        if(letters[i] != 0) {
            return false
        }
    }

    return true
}