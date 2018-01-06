package com.topic.linkedlist;

import com.util.Question;

@Question(id = 141, title = "Linked List Cycle")
public class ELinkedListCycle {

    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        int h;
        System.out.println((h = 20) ^ (h >>> 16));
    }
}
