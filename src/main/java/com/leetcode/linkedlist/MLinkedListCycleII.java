package com.leetcode.linkedlist;

import com.support.ListNode;
import com.util.Question;
import com.util.Self;

import java.util.Arrays;

@Question(id = 142, title = "Linked List Cycle II", hint = "" +
        "1. return the node where the cycle begins")
public class MLinkedListCycleII {

    @Self(thought = "two point", complexity = "O(n)")
    static ListNode solution(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode cyhead = head;
                while (cyhead != slow) {
                    slow = slow.next;
                    cyhead = cyhead.next;
                }
                return slow;
            }
        }
        return null;
    }


    public static void main(String[] args){
        int h;
        System.out.println((h = 20) ^ (h >>> 16));
        char[][] c = new char[10][10];
        Arrays.fill(c[0], '.');
        StringBuilder sb = new StringBuilder();
        sb.substring(0);
       // Arrays.deepToString()
    }
}
