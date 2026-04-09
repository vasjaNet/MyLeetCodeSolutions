package org.s3m.leetcode.easy._169

fun majorityElement(nums: IntArray): Int {
    val count = HashMap<Int, Int>()
    for(num in nums){
        count[num] = count.getOrDefault(num, 0) + 1
    }

    return count.maxByOrNull { it.value }?.key ?: 0

}

fun main() {
    val nums = intArrayOf(3,2,3)
    val result = majorityElement(nums)
    print(result)
}