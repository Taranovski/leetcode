package com.taranovski.leetcode.solutions.easy.leetcode0001.kotlin

/**
 * Created by Alyx on 27.09.2018.
 */
class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray? {
        val length = nums.size
        for (i in 0..length - 1) {
            for (j in 0..length - 1) {
                if (i != j) {
                    if (nums[i] + nums[j] == target) {
                        return intArrayOf(i, j)
                    }
                }
            }
        }
        return null
    }
}
