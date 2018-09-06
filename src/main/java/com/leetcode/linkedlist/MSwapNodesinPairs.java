package com.leetcode.linkedlist;

import com.support.ListNode;
import com.util.Question;

@Question(id = 24, hint = "Given a linked list, swap every two adjacent nodes and return its head.s")
public class MSwapNodesinPairs {

    // Swap Value not Node
    public ListNode swapPairs(ListNode head) {
        ListNode tmp = head;
        while (tmp != null && tmp.next != null) {
            int val = tmp.val;
            tmp.val = tmp.next.val;
            tmp.next.val = val;
            tmp = tmp.next.next;
        }
        return head;
    }

}
