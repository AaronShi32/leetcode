package com.topic.linkedlist;

import com.support.ListFactory;
import com.support.ListNode;
import com.util.Best;
import com.util.Question;
import com.util.Self;

@Question(id = 203, title = "Remove Linked List Elements")
public class ERemoveLinkedListElements {

    @Best
    @Self(thought = "fake head & double point: curr, prev", complexity = "O(n)")
    static ListNode solution(ListNode head, int val){
        ListNode fake = new ListNode(-1);
        fake.next = head;
        ListNode curr = head, prev = fake;
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            } else {
                prev = prev.next;
            }
            curr = curr.next;
        }
        return fake.next;
    }


    public static void main(String[] args){
        int[] nodes = {1,2,6,3,4,5,6};
        ListNode head = ListFactory.build(nodes);
        ListNode ret = solution(head, 6);
        ListFactory.print(ret);
    }
}
