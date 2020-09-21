package com.leetcode.solutions.easy;

import com.leetcode.common.ListNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 * <p>
 * Iterative solution
 * Time Complexity O(N)
 * Space Complexity O(N)
 */
public class _0206_ReverseLinkedList_02 {
    public ListNode reverseList(ListNode head) {
        List<Integer> list = new LinkedList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        Collections.reverse(list);

        ListNode result = new ListNode();
        ListNode dummy = result;

        for (int num : list) {
            dummy.next = new ListNode(num);
            dummy = dummy.next;
        }
        return result.next;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);

        node.print();
        _0206_ReverseLinkedList_02 solution = new _0206_ReverseLinkedList_02();
        ListNode result = solution.reverseList(node);
        result.print();
    }
}
