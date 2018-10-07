package com.taranovski.leetcode.solutions.easy.leetcode0917.kotlin

/**
 * Created by Alyx on 06.10.2018.
 */
class Solution {
    fun reverseOnlyLetters(S: String): String {
        val chars = S.toCharArray()

        val length = chars.size

        var left = 0
        var right = length - 1


        while (right > left) {
            while (left < length && !Character.isAlphabetic(chars[left].toInt())) {
                left++
            }

            while (right > 0 && !Character.isAlphabetic(chars[right].toInt())) {
                right--
            }

            if (right > left) {
                val temp = chars[left]
                chars[left] = chars[right]
                chars[right] = temp
                left++
                right--
            }

        }

        return String(chars)
    }
}
