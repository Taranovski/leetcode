package com.taranovski.leetcode.solutions.easy.leetcode0007;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

/**
 * Created by Alyx on 29.09.2018.
 */
@RunWith(Parameterized.class)
public class SolutionTest {

    private int input;
    private int output;

    public SolutionTest(int input, int output) {
        this.input = input;
        this.output = output;
    }

    @Parameterized.Parameters
    public static Object[][] params() {
        return new Object[][]{
                {123, 321},
                {1230, 321},
                {-123, -321},
                {0, 0},
                {-2147483648, 0},
        };
    }

    private Solution solution = new Solution();

    @Test
    public void shouldReturnTheRightAnswerForAGivenSequence(){
        final int lengthOfLongestSubstring = solution.reverse(input);

        assertEquals(output, lengthOfLongestSubstring);
    }
}