package org.s3m.leetcode.hard._30

fun findSubstring(s: String, words: Array<String>): List<Int> {
    val result = mutableListOf<Int>()
    val cnt = HashMap<String, Int>()
    for (w in words) {
        cnt.merge(w, 1) { old, new -> old + new }
    }
    val m = s.length
    val n = words.size
    val k = words[0].length

    for (i in 0 until k) {
        var l = i
        var r = i
        val cnt1 = HashMap<String, Int>()
        while (r + k <= m) {
            val t = s.substring(r, r + k)
            r += k
            if (!cnt.containsKey(t)) {
                cnt1.clear()
                l = r
                continue
            }
            cnt1.merge(t, 1) { old, new -> old + new }
            while (cnt1[t]?: 0 > cnt[t]?: 0) {
                val w = s.substring(l, l + k)
                if (cnt1.merge(w, -1) { old, new -> old + new } == 0) {
                    cnt1.remove(w)
                }
                l += k
            }
            if (r - l == n * k) {
                result.add(l)
            }
        }
    }

    return result
}