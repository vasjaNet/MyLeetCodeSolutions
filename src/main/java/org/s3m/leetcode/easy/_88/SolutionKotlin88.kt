package org.s3m.leetcode.easy._88



    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var i : Int = nums1.lastIndex
        var mi : Int = m - 1
        var ni : Int = n - 1
        if(n == 0) return
        while(i >= 0) {
            if(mi >= 0 && nums1[mi] > nums2[ni]) {
                nums1[i] = nums1[mi--]
            } else {
                nums1[i] = nums2[ni--]
                if(ni<0) return
            }
            i--
        }
    }

    fun main() {
        val nums1 = intArrayOf(1,2,3,0,0,0)
        val m = 3
        val nums2 = intArrayOf(2,5,6)
        val n = 3
        merge(nums1, m, nums2, n)
        for (i in nums1) {
            print("$i ")
        }
    }
