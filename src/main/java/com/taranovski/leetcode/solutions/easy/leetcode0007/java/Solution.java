package com.taranovski.leetcode.solutions.easy.leetcode0007.java;

/**
 * Created by Alyx on 29.09.2018.
 */
public class Solution {
    public int reverse(int x) {

        if (x == 0) {
            return 0;
        }

        boolean isNegative = x < 0;
        long number = isNegative ? (- (long) x) : ((long) x);

        StringBuilder stringBuilder = new StringBuilder();

        long remainder1;
        do {
            remainder1 = number % 10;
            if (remainder1 == 0) {
                number = number / 10;
            }
        } while (remainder1 == 0);

        while (number > 0) {
            long remainder = number % 10;
            number = number / 10;

            stringBuilder.append(remainder);
        }

        final long parseLong = Long.parseLong(stringBuilder.toString());

        if (isNegative && -parseLong < Integer.MIN_VALUE) {
            return 0;
        }
        if (!isNegative && parseLong > Integer.MAX_VALUE) {
            return 0;
        }
        return isNegative ? (- (int) parseLong) : ((int) parseLong);
    }

}
