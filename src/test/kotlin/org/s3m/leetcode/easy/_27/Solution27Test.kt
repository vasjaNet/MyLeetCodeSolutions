package org.s3m.leetcode.easy._27

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Solution27Test {
    @Test
    fun testRemoveElement() {
        val nums = intArrayOf(3, 2, 2, 3)
        val k = removeElement(nums, 3)
        Assertions.assertEquals(2, k)
        Assertions.assertArrayEquals(intArrayOf(2, 2), nums.copyOfRange(0, k))
    }

    @Test
    fun testRemoveElement2() {
        val nums = intArrayOf(0, 1, 2, 2, 3, 0, 4, 2)
        val k = removeElement(nums, 2)
        Assertions.assertEquals(5, k)
        val result = nums.copyOfRange(0, k).sortedArray()
        Assertions.assertArrayEquals(intArrayOf(0, 0, 1, 3, 4), result)
    }
}