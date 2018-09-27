package com.taranovski.leetcode.solutions.medium.leetcode0003;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

/**
 * Created by Alyx on 27.09.2018.
 */
@RunWith(Parameterized.class)
public class SolutionTest {

    private String input;
    private int output;

    public SolutionTest(String input, int output) {
        this.input = input;
        this.output = output;
    }

    @Parameterized.Parameters
    public static Object[][] params() {
            return new Object[][]{
                    {"abc", 3},
                    {"aabaab!bb", 3},
            };
    }

    private Solution solution = new Solution();

    @Test
    public void shouldReturnTheRightAnswerForAGivenSequence(){
        final int lengthOfLongestSubstring = solution.lengthOfLongestSubstring(input);

        assertEquals(output, lengthOfLongestSubstring);
    }
}