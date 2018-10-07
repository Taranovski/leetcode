package com.taranovski.leetcode.solutions.medium.leetcode0916.kotlin

import java.util.ArrayList
import java.util.HashMap

/**
 * Created by Alyx on 29.09.2018.
 */
class Solution {
    fun wordSubsets(A: Array<String>, B: Array<String>): List<String> {

        val globalRequirements = HashMap<Char, Int>()

        for (s in B) {
            val requirements = getRequirements(s)
            mergeToGlobalRequirements(globalRequirements, requirements)
        }

        val result = ArrayList<String>()

        for (s in A) {
            if (conformsToRequirements(s, globalRequirements)) {
                result.add(s)
            }
        }

        return result
    }

    private fun conformsToRequirements(s: String, globalRequirements: Map<Char, Int>): Boolean {
        val requirements = getRequirements(s)

        for ((key, globalCounter) in globalRequirements) {
            if (!requirements.containsKey(key)) {
                return false
            } else {
                val currentCounter = requirements[key]!!

                if (currentCounter < globalCounter) {
                    return false
                }
            }
        }

        return true
    }

    private fun mergeToGlobalRequirements(globalRequirements: MutableMap<Char, Int>, requirements: Map<Char, Int>) {
        for ((key, value) in requirements) {
            if (globalRequirements.containsKey(key)) {
                val globalCounter = globalRequirements[key]!!
                if (value > globalCounter) {
                    globalRequirements.put(key, value)
                }
            } else {
                globalRequirements.put(key, value)
            }
        }
    }

    private fun getRequirements(s: String): Map<Char, Int> {
        val requirements = HashMap<Char, Int>()
        for (c in s.toCharArray()) {
            if (!requirements.containsKey(c)) {
                requirements.put(c, 0)
            }
            requirements.put(c, requirements[c]!! + 1)
        }
        return requirements
    }
}
