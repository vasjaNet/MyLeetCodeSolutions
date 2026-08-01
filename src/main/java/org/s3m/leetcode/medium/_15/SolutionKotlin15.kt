package org.s3m.leetcode.medium._15

fun threeSum(nums: IntArray): List<List<Int>> {
    nums.sort()
    val result = mutableListOf<List<Int>>()
    for(i in 0 until nums.size-2) {
        if(i > 0 && nums[i] == nums[i-1]) continue
        if(nums[i]>0) break
        var j = i + 1
        var k = nums.size -1
        while(j < k) {
            val sum = nums[i] + nums[j] + nums[k]
            if(sum == 0) {
                result.add(listOf(nums[i], nums[j], nums[k]))
                while(j < k && nums[j] == nums[j+1]) j++
                while(j < k && nums[k] == nums[k-1]) k--
                j++
            } else if(sum > 0) {
                k--
            } else {
                j++
            }
        }
    }
    return result
}