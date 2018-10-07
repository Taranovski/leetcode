package com.taranovski.leetcode.solutions.easy.leetcode0917.java;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

/**
 * Created by Alyx on 06.10.2018.
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
                {"ab-cd", "dc-ba"},
                {"a-bC-dEf-ghIj", "j-Ih-gfE-dCba"},
                {"Test1ng-Leet=code-Q!", "Qedo1ct-eeLg=ntse-T!"},
                {"7_28]", "7_28]"},
        };
    }

    private Solution solution = new Solution();

    @Test
    public void shouldReturnTheRightAnswerForAGivenSequence(){
        final String lengthOfLongestSubstring = solution.reverseOnlyLetters(input);

        assertEquals(output, lengthOfLongestSubstring);
    }
}