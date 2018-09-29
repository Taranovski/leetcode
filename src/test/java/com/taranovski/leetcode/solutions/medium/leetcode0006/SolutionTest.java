package com.taranovski.leetcode.solutions.medium.leetcode0006;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

/**
 * Created by Alyx on 29.09.2018.
 */
@RunWith(Parameterized.class)
public class SolutionTest {

    private String input;
    private int numberOfRows;
    private String output;

    public SolutionTest(String input, int numberOfRows, String output) {
        this.input = input;
        this.numberOfRows = numberOfRows;
        this.output = output;
    }

    @Parameterized.Parameters
    public static Object[][] params() {
        return new Object[][]{
                {"PAYPALISHIRING", 3, "PAHNAPLSIIGYIR"},
                {"PAYPALISHIRING", 4, "PINALSIGYAHRPI"},
                {"A", 4, "A"},
                {"A", 1, "A"},
                {"AB", 1, "AB"},
        };
    }

    private Solution solution = new Solution();

    @Test
    public void shouldReturnTheRightAnswerForAGivenSequence() {
        final String lengthOfLongestSubstring = solution.convert(input, numberOfRows);

        assertEquals(output, lengthOfLongestSubstring);
    }
}