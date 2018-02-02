package com.topic.linkedlist;

import com.support.ListNode;
import com.util.Question;

@Question(id = 83, title = "Remove Duplicates from Sorted List", hint = "" +
        "1. Given a sorted linked list, delete all duplicates such that each element appear only once.")
public class ERemoveDuplicatesfromSortedList {

    public static ListNode solution(ListNode head) {

        ListNode point = head;

        while(point != null) {
            if (point.next == null) {
                break;
            }
            if (point.val == point.next.val) {
                point.next = point.next.next;
            } else {
                point = point.next;
            }
        }

        return head;
    }

    public static void main(String[] args){

    }
}
