package com.topic.linkedlist;

import com.util.Question;
import com.util.Self;

import java.util.Collections;

@Question(id = 19, title = "Remove Nth Node From End of List")
public class MRemoveNthNodeFromEndofList {

    @Self(thought = "", complexity = "")
    static ListNode solution(ListNode head, int n){
        ListNode fake = new ListNode(-1);
        fake.next = head;
        ListNode slow = fake, fast = fake;
        for(int i = 0; i <= n; i++){
            fast = fast.next;
        }
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;

        return fake.next;
    }


    public static void main(String[] args){
        ListNode nodes = ListFactory.build(new int[]{1,2});
        ListFactory.print(solution(nodes, 1));

    }
}
