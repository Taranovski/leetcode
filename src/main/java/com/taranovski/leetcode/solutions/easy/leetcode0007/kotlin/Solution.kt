package com.taranovski.leetcode.solutions.easy.leetcode0007.kotlin

/**
 * Created by Alyx on 29.09.2018.
 */
class Solution {
    fun reverse(x: Int): Int {

        if (x == 0) {
            return 0
        }

        val isNegative = x < 0
        var number = if (isNegative) -x.toLong() else x.toLong()

        val stringBuilder = StringBuilder()

        var remainder1: Long
        do {
            remainder1 = number % 10
            if (remainder1 == 0L) {
                number /= 10
            }
        } while (remainder1 == 0L)

        while (number > 0) {
            val remainder = number % 10
            number /= 10

            stringBuilder.append(remainder)
        }

        val parseLong = java.lang.Long.parseLong(stringBuilder.toString())

        if (isNegative && -parseLong < Integer.MIN_VALUE) {
            return 0
        }
        if (!isNegative && parseLong > Integer.MAX_VALUE) {
            return 0
        }
        return if (isNegative) -parseLong.toInt() else parseLong.toInt()
    }

}
