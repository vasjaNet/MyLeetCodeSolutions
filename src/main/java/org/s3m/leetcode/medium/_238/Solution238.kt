package org.s3m.leetcode.medium._238

fun productExceptSelf(nums: IntArray): IntArray {
    var zeroIndex = -1
    var product = 1
    val result = IntArray(nums.size)
    for(i in nums.indices) {
        if(nums[i] == 0) {
            if(zeroIndex != -1) { return result }
            zeroIndex = i
        } else{
            product *= nums[i]
        }
    }
    if(zeroIndex != -1) {
        result[zeroIndex] = product
        return result
    }
    for(i in nums.indices) {
        result[i] = product / nums[i]
    }
    return result
}

fun main() {
    val nums = intArrayOf(1,2,3,4)
    val result = productExceptSelf(nums)
    for (i in result) {
        print("$i ")
    }

}