package org.s3m.leetcode.easy._205

fun isIsomorphic(s: String, t: String): Boolean {
    if(s.length != t.length) return false
    val map =  HashMap<Char, Char>()
    val mapReverse = HashMap<Char, Char>()
    for(i in 0 until s.length) {
        if(map.containsKey(s[i]) || mapReverse.containsKey(t[i])) {
            if (map[s[i]] != t[i] || mapReverse[t[i]] != s[i]) {
                return false
            }
        } else {
            map[s[i]] = t[i]
            mapReverse[t[i]] = s[i]
        }
    }
    return true
}
