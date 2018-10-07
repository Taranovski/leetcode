package com.taranovski.leetcode.solutions.medium.leetcode0003.kotlin

/**
 * Created by Alyx on 26.09.2018.
 */
internal class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var maxLength = 0

        val maxSubstring = StringBuilder()

        for (c in s.toCharArray()) {
            val indexOf = maxSubstring.indexOf("" + c)
            if (indexOf != -1) {
                maxSubstring.delete(0, indexOf + 1)
            }
            maxSubstring.append(c)
            val length = maxSubstring.length
            if (maxLength < length) {
                maxLength = length
            }
        }

        return maxLength
    }
}
