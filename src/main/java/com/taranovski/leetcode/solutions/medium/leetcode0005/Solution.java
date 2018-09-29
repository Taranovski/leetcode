package com.taranovski.leetcode.solutions.medium.leetcode0005;

/**
 * Created by Alyx on 27.09.2018.
 */
public class Solution {
    public String longestPalindrome(String s) {
        final String inputString = s;
        final String reversedString = new StringBuilder(s).reverse().toString();

        final int length = inputString.length();
        int longestPalindromeLength = length == 0 ? 0 : 1;
        String longestPalindrome = length == 0 ? "" : "" + inputString.charAt(0);

        int[] compareFull = compareSubstrings(inputString, 0, reversedString, 0, length);

        int[] lengthAndStartIndexOfTheLongestPalindromeFull = getLengthAndStartIndexOfTheLongestPalindrome(compareFull);

        final int lengthOfThePalindromeFull = lengthAndStartIndexOfTheLongestPalindromeFull[0];
        final int beginIndexFull = lengthAndStartIndexOfTheLongestPalindromeFull[1];
        if (lengthOfThePalindromeFull > longestPalindromeLength) {
            longestPalindrome = inputString.substring(beginIndexFull, beginIndexFull + lengthOfThePalindromeFull);
            longestPalindromeLength = lengthOfThePalindromeFull;
        }

        for (int i = 2; i <= length; i++) {
            int[] compare = compareSubstrings(inputString, 0, reversedString, length - i, i);

            int[] lengthAndStartIndexOfTheLongestPalindrome = getLengthAndStartIndexOfTheLongestPalindrome(compare);

            final int lengthOfThePalindrome = lengthAndStartIndexOfTheLongestPalindrome[0];
            final int beginIndex = lengthAndStartIndexOfTheLongestPalindrome[1];
            if (lengthOfThePalindrome > longestPalindromeLength) {
                longestPalindrome = inputString.substring(beginIndex, beginIndex + lengthOfThePalindrome);
                longestPalindromeLength = lengthOfThePalindrome;
            }
        }

        for (int i = 1; i <= length - 2; i++) {
            int[] compare = compareSubstrings(inputString, i, reversedString, 0, length - i);

            int[] lengthAndStartIndexOfTheLongestPalindrome = getLengthAndStartIndexOfTheLongestPalindrome(compare);

            final int lengthOfThePalindrome = lengthAndStartIndexOfTheLongestPalindrome[0];
            final int beginIndex = lengthAndStartIndexOfTheLongestPalindrome[1] + i;
            if (lengthOfThePalindrome > longestPalindromeLength) {
                longestPalindrome = inputString.substring(beginIndex, beginIndex + lengthOfThePalindrome);
                longestPalindromeLength = lengthOfThePalindrome;
            }
        }

        return longestPalindrome;

    }

    private int[] getLengthAndStartIndexOfTheLongestPalindrome(int[] compare) {
        final int[] lengthAndStartIndex = new int[2];

        final int length = compare.length;

        int tempLength = 0;
        int tempStartIndex = 0;

        int maxLength = 0;
        int maxStartIndex = 0;

        for (int i = 0; i < length; i++) {
            if (compare[i] == 0) {
                if (tempLength == 0) {
                    tempStartIndex = i;
                }
                tempLength++;
                if (tempLength > maxLength) {
                    maxLength = tempLength;
                    maxStartIndex = tempStartIndex;
                }
            } else {
                tempLength = 0;
            }
        }

        lengthAndStartIndex[0] = maxLength;
        lengthAndStartIndex[1] = maxStartIndex;

        return lengthAndStartIndex;
    }

    private int[] compareSubstrings(String inputString, int inputStringStartIndex, String reversedString, int reversedStringStartIndex, int length) {
        final int[] ints = new int[length];

        for (int i = 0; i < length; i++) {
            ints[i] = inputString.charAt(inputStringStartIndex + i) - reversedString.charAt(reversedStringStartIndex + i);
        }

        return ints;
    }
}
