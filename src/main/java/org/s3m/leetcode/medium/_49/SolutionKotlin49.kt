package org.s3m.leetcode.medium._49

fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val map = HashMap<String, List<String>>()
    for(str in strs) {
        val key = str.toCharArray().sorted().joinToString("")
        if(map.containsKey(key)) {
            map[key]?.let { currentArray ->
                map[key] = currentArray + str
            }
        } else {
            map[key] = mutableListOf(str)
        }
    }
    return map.values.map {it as List<String>}
}