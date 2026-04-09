package org.s3m.leetcode.medium._80

fun removeDuplicates(nums: IntArray): Int {
    var i = 0
    var k = 1
    var count = 0
    while(k < nums.size) {
        if(nums[i] == nums[k]) {
            if(count < 1) {
                nums[++i] = nums[k]
            }
            k++
            count++
        } else {
            count = 0
            nums[++i] = nums[k]
            k++
        }
    }
    return i+1
}

fun main() {
    val nums = intArrayOf(1,1,1,2,2,3)
    val result = removeDuplicates(nums)
    for (i in 0..<result) {
        print("${nums[i]} ")
    }
}