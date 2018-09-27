package com.taranovski.leetcode.solutions.leetcode0002;

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
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return summRecursively(l1, l2, 0);
    }

    private ListNode summRecursively(ListNode first, ListNode second, int carryOver) {
        if (first == null && second == null && carryOver == 0) {
            return null;
        }

        final int summOfDigits = (first == null ? 0 : first.val) + (second == null ? 0 : second.val) + carryOver;

        final boolean summIsMoreThanNine = summOfDigits > 9;
        final ListNode listNode = new ListNode(summIsMoreThanNine ? summOfDigits % 10 : summOfDigits);
        listNode.next = summRecursively(first == null ? null : first.next, second == null ? null : second.next, summIsMoreThanNine ? 1 : 0);
        return listNode;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}