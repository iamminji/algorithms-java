package com.leetcode.solutions.medium;

import com.leetcode.common.ListNode;

/**
 * https://leetcode.com/problems/add-two-numbers/
 * <p>
 * ListNode l1 (N개), l2(M개) 에서 더 큰 값을 M 이라고 했을 때
 * Time Complexity: O(M)
 * Space Complexity: O(M)
 * <p>
 * 풀이 시간 30M
 */
public class _0002_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode();
        ListNode result = dummy;

        int carry = 0;

        while (l1 != null || l2 != null) {

            int sum = 0;
            if (l1 != null && l2 != null) {
                sum = carry + l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 != null && l2 == null) {
                sum = carry + l1.val;
                l1 = l1.next;
            } else {
                sum = carry + l2.val;
                l2 = l2.next;
            }
            if (sum >= 10) {
                carry = sum / 10;
            } else {
                carry = 0;
            }

            dummy.next = new ListNode(sum % 10);

            dummy = dummy.next;
        }

        if (carry > 0) {
            dummy.next = new ListNode(carry);
        }

        return result.next;

    }
}
