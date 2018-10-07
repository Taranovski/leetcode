package com.taranovski.leetcode.solutions.easy.leetcode0001.java;

/**
 * Created by Alyx on 27.09.2018.
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        final int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i != j) {
                    if (nums[i] + nums[j] == target) {
                        return new int[]{i, j};
                    }
                }
            }
        }
        return null;
    }
}
