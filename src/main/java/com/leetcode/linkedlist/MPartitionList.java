package com.topic.linkedlist;

import com.support.ListNode;
import com.util.Question;

import java.util.Deque;
import java.util.LinkedList;

@Question(id = 86, hint = "Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.")
public class MPartitionList {

    public ListNode partition(ListNode head, int x) {

        if(head == null){
            return null;
        }

        ListNode fake = new ListNode(-1);
        fake.next = head;
        ListNode point = fake;
        Deque<ListNode> deque = new LinkedList<>();

        while(point.next != null){
            if(point.next.val > x){
                deque.add(point.next);
                point.next = point.next.next;
            } else {
                point = point.next;
            }
        }

        while (!deque.isEmpty()) {
            point.next = deque.remove();
            point = point.next;
        }

        point.next = null; // Important to have a valid LL.
        return fake.next;
    }

}
