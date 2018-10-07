package com.taranovski.leetcode.solutions.easy.leetcode0917.java;

/**
 * Created by Alyx on 06.10.2018.
 */
public class Solution {
    public String reverseOnlyLetters(String S) {
        final char[] chars = S.toCharArray();

        final int length = chars.length;

        int left = 0;
        int right = length - 1;


        while (right > left) {
            while (left < length && !Character.isAlphabetic(chars[left])) {
                left++;
            }

            while (right > 0 && !Character.isAlphabetic(chars[right])) {
                right--;
            }

            if (right > left) {
                final char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }

        }

        return new String(chars);
    }
}
