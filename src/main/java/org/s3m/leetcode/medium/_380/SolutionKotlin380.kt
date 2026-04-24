package org.s3m.leetcode.medium._380

import kotlin.random.Random

class SolutionKotlin380 {
    class RandomizedSet() {
        private val data = mutableListOf<Int>()
        private val map = mutableMapOf<Int, Int>()

        fun insert(`val`: Int): Boolean {
            if(map.containsKey(`val`)) return false

            data.add(`val`)
            map[`val`] = data.lastIndex
            return true
        }

        fun remove(`val`: Int): Boolean {
            val index = map.remove(`val`) ?: return false

            val last = data.last()
            if(index != data.size - 1) {
                data[index] = last
                map[last] = index
            }
            data.removeAt(data.size - 1)
            return true
        }

        fun getRandom(): Int {
            return data[Random.nextInt(data.size)]
        }

    }
}