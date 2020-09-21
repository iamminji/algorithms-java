package com.leetcode.solutions.easy;

import com.leetcode.common.ListNode;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 *
 * Iterative solution
 * Time Complexity O(N)
 * Space Complexity O(1)
 */
public class _0206_ReverseLinkedList_01 {
    public ListNode reverseList(ListNode head) {
        ListNode result = null;

        while (head != null) {
            ListNode temp = head.next;
            head.next = result;
            result = head;
            head = temp;
        }
        return result;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);

        node.print();
        _0206_ReverseLinkedList_01 solution = new _0206_ReverseLinkedList_01();
        ListNode result = solution.reverseList(node);
        result.print();

    }
}
