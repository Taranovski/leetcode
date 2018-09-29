package com.taranovski.leetcode.solutions.medium.failing.leetcode0005;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

/**
 * Created by Alyx on 28.09.2018.
 */
@RunWith(Parameterized.class)
public class SolutionTest {

    private String input;
    private String output;

    public SolutionTest(String input, String output) {
        this.input = input;
        this.output = output;
    }

    @Parameterized.Parameters
    public static Object[][] params() {
        return new Object[][]{
                {"abc", "a"},
                {"aabaab!bb", "aabaa"},
                {"aabdab!bbaabaab", "baabaab"},
                {"cbbd", "bb"},
                {"abb", "bb"},
                {"aacdefcaa", "aa"},
        };
    }

    private Solution solution = new Solution();

    @Test
    public void shouldReturnTheRightAnswerForAGivenSequence(){
        final String lengthOfLongestSubstring = solution.longestPalindrome(input);

        assertEquals(output, lengthOfLongestSubstring);
    }
}