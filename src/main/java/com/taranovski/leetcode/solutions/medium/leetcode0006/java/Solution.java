package com.taranovski.leetcode.solutions.medium.leetcode0006.java;

/**
 * Created by Alyx on 28.09.2018.
 */
public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder stringBuilder = new StringBuilder();

        int fullIncrement = (numRows - 1) * 2;
        final int lastRow = numRows - 1;
        final int length = s.length();

        for (int i = 0; i < numRows; i++) {
            if (i == 0) {
                int j = 0;
                while (j < length) {
                    stringBuilder.append(s.charAt(j));
                    j += fullIncrement;
                }
            } else if (i == lastRow) {
                int j = lastRow;
                while (j < length) {
                    stringBuilder.append(s.charAt(j));
                    j += fullIncrement;
                }
            } else {
                int j = i;
                int k = fullIncrement - i;

                while (j < length || k < length) {
                    if (j < length) {
                        stringBuilder.append(s.charAt(j));
                        j += fullIncrement;
                    }
                    if (k < length) {
                        stringBuilder.append(s.charAt(k));
                        k += fullIncrement;
                    }
                }
            }

        }

        return stringBuilder.toString();
    }
}
