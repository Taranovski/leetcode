package com.taranovski.leetcode.solutions.medium.leetcode0003;

/**
 * Created by Alyx on 26.09.2018.
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;

        StringBuilder maxSubstring = new StringBuilder();

        for (char c : s.toCharArray()) {
            final int indexOf = maxSubstring.indexOf("" + c);
            if (indexOf != -1) {
                maxSubstring.delete(0, indexOf + 1);
            }
            maxSubstring.append(c);
            final int length = maxSubstring.length();
            if (maxLength < length) {
                maxLength = length;
            }
        }

        return maxLength;
    }
}
