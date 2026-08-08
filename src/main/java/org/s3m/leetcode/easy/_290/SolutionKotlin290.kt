package org.s3m.leetcode.easy._290

fun wordPattern(pattern: String, s: String): Boolean {
    val words = s.split(" ")
    if(pattern.length != words.size) return false
    val map =  HashMap<Char, String>()
    //val mapReverse = HashMap<Char, Char>()
    for(i in 0 until pattern.length) {
        val word = words[i]
        val c = pattern[i]
        if(map.containsKey(c) && !map[c].equals(word)) {
            return false
        }
        if(!map.containsKey(c) && map.containsValue(word)) {
            return false
        }
        map.put(c, word)
    }
    return true
}