package com.leetcode.prime;

import com.support.ListFactory;
import com.support.ListNode;

public class MPlusOneLinkedList {

    public static ListNode plusOne(ListNode head) {
        head = reverse(head);
        plus(head);
        head = reverse(head);
        return head;
    }

    private static void plus(ListNode head) {
        ListNode point = head, pre = null;
        int carry = 1;
        while (point != null) {
            int sum = point.val + carry;
            point.val = sum % 10;
            carry = sum / 10;
            pre = point;
            point = point.next;
        }
        if (carry == 1) {
            pre.next = new ListNode(1);
        }
    }

    private static ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        return pre;
    }

    public static void main(String[] args) {
        int[] val = {9, 8, 9, 8, 9};
        ListNode head = ListFactory.build(val);
        ListFactory.print(head);
        System.out.println();
        head = plusOne(head);
        ListFactory.print(head);

    }

}
