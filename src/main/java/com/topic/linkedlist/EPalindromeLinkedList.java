package com.topic.linkedlist;

import com.support.ListNode;
import com.util.Best;
import com.util.Question;
import com.util.Self;

@Question(id = 234, title = "Palindrome Linked List", hint = "" +
        "1. O(n) time and O(1) space")
public class EPalindromeLinkedList {

    @Best(thought = "fast & slow & reverse")
    @Self(thought = "miss")
    public boolean solution(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) { // odd nodes: let right half smaller
            slow = slow.next;
        }
        slow = reverse(slow);
        fast = head;

        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }


    public static void main(String[] args){

    }

}
