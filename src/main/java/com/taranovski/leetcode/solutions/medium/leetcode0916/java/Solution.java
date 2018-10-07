package com.taranovski.leetcode.solutions.medium.leetcode0916.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Alyx on 29.09.2018.
 */
public class Solution {
    public List<String> wordSubsets(String[] A, String[] B) {

        Map<Character, Integer> globalRequirements = new HashMap<>();

        for (String s : B) {
            Map<Character, Integer> requirements = getRequirements(s);
            mergeToGlobalRequirements(globalRequirements, requirements);
        }

        List<String> result = new ArrayList<>();

        for (String s : A) {
            if (conformsToRequirements(s, globalRequirements)) {
                result.add(s);
            }
        }

        return result;
    }

    private boolean conformsToRequirements(String s, Map<Character, Integer> globalRequirements) {
        final Map<Character, Integer> requirements = getRequirements(s);

        for (Map.Entry<Character, Integer> entry : globalRequirements.entrySet()) {
            final Character key = entry.getKey();
            if (!requirements.containsKey(key)) {
                return false;
            } else {
                final Integer globalCounter = entry.getValue();
                final Integer currentCounter = requirements.get(key);

                if (currentCounter < globalCounter) {
                    return false;
                }
            }
        }

        return true;
    }

    private void mergeToGlobalRequirements(Map<Character, Integer> globalRequirements, Map<Character, Integer> requirements) {
        for (Map.Entry<Character, Integer> entry : requirements.entrySet()) {
            final Character key = entry.getKey();
            final Integer value = entry.getValue();
            if (globalRequirements.containsKey(key)) {
                final Integer globalCounter = globalRequirements.get(key);
                if (value > globalCounter) {
                    globalRequirements.put(key, value);
                }
            } else {
                globalRequirements.put(key, value);
            }
        }
    }

    private Map<Character, Integer> getRequirements(String s) {
        Map<Character, Integer> requirements = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (!requirements.containsKey(c)) {
                requirements.put(c, 0);
            }
            requirements.put(c, requirements.get(c) + 1);
        }
        return requirements;
    }
}
