package com.taranovski.leetcode.solutions.medium.leetcode0006.kotlin

/**
 * Created by Alyx on 28.09.2018.
 */
class Solution {
    fun convert(s: String, numRows: Int): String {
        if (numRows == 1) {
            return s
        }
        val stringBuilder = StringBuilder()

        val fullIncrement = (numRows - 1) * 2
        val lastRow = numRows - 1
        val length = s.length

        for (i in 0..numRows - 1) {
            if (i == 0) {
                var j = 0
                while (j < length) {
                    stringBuilder.append(s[j])
                    j += fullIncrement
                }
            } else if (i == lastRow) {
                var j = lastRow
                while (j < length) {
                    stringBuilder.append(s[j])
                    j += fullIncrement
                }
            } else {
                var j = i
                var k = fullIncrement - i

                while (j < length || k < length) {
                    if (j < length) {
                        stringBuilder.append(s[j])
                        j += fullIncrement
                    }
                    if (k < length) {
                        stringBuilder.append(s[k])
                        k += fullIncrement
                    }
                }
            }

        }

        return stringBuilder.toString()
    }
}
