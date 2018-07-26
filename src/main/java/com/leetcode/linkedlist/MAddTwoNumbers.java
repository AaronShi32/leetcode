package com.topic.linkedlist;

import com.support.ListNode;
import com.util.Question;

import java.math.BigInteger;

@Question(id = 2, hint = "The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.")
public class MAddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode fake = new ListNode(-1);

        ListNode point = fake;

        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int total = carry;
            if (l1 != null) {
                total += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                total += l2.val;
                l2 = l2.next;
            }
            int sum = total % 10;
            carry = total / 10;
            point.next = new ListNode(sum);
            point = point.next;
        }

        return fake.next;
    }

}
