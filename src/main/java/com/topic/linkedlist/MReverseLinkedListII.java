package com.topic.linkedlist;

import com.util.Question;
import com.util.Self;

import java.util.Stack;

@Question(id = 92, title = "Reverse Linked List II", hint = "" +
        "1. Reverse a linked list from position m to n. " +
        "2. Do it in-place and in one-pass.")
public class MReverseLinkedListII {

    @Self(thought = "stack", complexity = "")
    static ListNode solution(ListNode head, int m, int n){
        if(head == null)
            return null;

        ListNode fake = new ListNode(-1);
        fake.next = head;

        ListNode pre = fake;

        for(int i = 0; i < m - 1; i++){
            pre = pre.next;
        }

        ListNode start = pre.next;
        ListNode then = start.next;

        for(int i = 0; i < n - m; i++){
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }

        return fake.next;


    }


    public static void main(String[] args){
        ListNode head = ListFactory.build(new int[]{1,2,3,4,5});
        ListFactory.print(solution(head,2 ,4));

    }
}
