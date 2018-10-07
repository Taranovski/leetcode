package com.taranovski.leetcode.solutions.medium.leetcode0002.kotlin

/**
 * Created by Alyx on 26.09.2018.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
internal class Solution {
    fun addTwoNumbers(l1: ListNode, l2: ListNode): ListNode {
        return summRecursively(l1, l2, 0)!!
    }

    private fun summRecursively(first: ListNode?, second: ListNode?, carryOver: Int): ListNode? {
        if (first == null && second == null && carryOver == 0) {
            return null
        }

        val summOfDigits = if (first == null) 0 else first.`val` + (if (second == null) 0 else second.`val`) + carryOver

        val summIsMoreThanNine = summOfDigits > 9
        val listNode = ListNode(if (summIsMoreThanNine) summOfDigits % 10 else summOfDigits)
        listNode.next = summRecursively(first?.next, second?.next, if (summIsMoreThanNine) 1 else 0)
        return listNode
    }

    inner class ListNode internal constructor(internal var `val`: Int) {
        internal var next: ListNode? = null
    }
}