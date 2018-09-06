package com.leetcode.linkedlist;

import com.support.ListFactory;
import com.support.ListNode;
import com.util.Question;

import java.util.Deque;
import java.util.LinkedList;

@Question(id = 143, hint = "1. Given a singly linked list L: L0→L1→…→Ln-1→Ln" +
        "2. reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…" +
        "3. You may not modify the values in the list's nodes, only nodes itself may be changed.")
public class MReorderList {

    public static void reorderList(ListNode head) {

        Deque<ListNode> deque = new LinkedList<>();

        ListNode cur = head;

        while(cur != null){
            deque.offerLast(cur);
            cur = cur.next;
        }

        cur = deque.pollFirst();
        ListNode next = null;
        boolean pollHead = false;
        while (!deque.isEmpty()){
            next = pollHead ? deque.pollFirst() : deque.pollLast();
            cur.next = next;
            cur = next;
            pollHead = !pollHead;
        }
        if(cur != null){
            cur.next = null;
        }
    }


    public static void main(String[] args){
        ListNode head = ListFactory.build(new int[]{1,2,3,4,5});
        reorderList(head);
        ListFactory.print(head);
    }
}
