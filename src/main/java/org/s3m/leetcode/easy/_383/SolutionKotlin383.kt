package org.s3m.leetcode.easy._383

fun canConstruct(ransomNote: String, magazine: String): Boolean {
    if(ransomNote.length > magazine.length) return false
    val letters = IntArray(26)
    for(i in 0 until magazine.length) {
        val index = magazine[i] - 'a'
        letters[index]++
    }
    for(j in 0 until ransomNote.length) {
        val index =  ransomNote[j] - 'a'
        if(letters[index] == 0) return false
        letters[index]--
    }
    return true
}