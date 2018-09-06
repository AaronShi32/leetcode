package com.leetcode.linkedlist;

import com.support.ListFactory;
import com.support.ListNode;

public class MRotateList {

    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0){
            return head;
        }
        int len = 0;
        ListNode fake = new ListNode(-1);
        fake.next = head;
        ListNode fast = fake;
        for(; fast.next != null; fast = fast.next){
            len++;
        }
        ListNode slow = fake;
        int r = len - k % len;
        while(r > 0){
            slow = slow.next;
            r --;
        }
        fast.next = fake.next; //Do the rotation
        fake.next = slow.next;
        slow.next = null;
        return fake.next;

    }

    public static void main(String[] args){
        ListNode head = ListFactory.build(new int[]{1,2,3,4,5});
        ListFactory.print(rotateRight(head, 2));
    }
}
