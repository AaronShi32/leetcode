package com.leetcode.linkedlist;

import com.support.ListFactory;
import com.support.ListNode;
import com.util.Question;
import com.util.Self;

import java.util.PriorityQueue;

@Question(id = 148, title = "Sort List", hint = "" +
        "1. Sort a linked list in O(n log n) time using constant space complexity.")
public class MSortList {

    public static ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        while(head != null){
            pq.offer(new ListNode(head.val));
            head = head.next;
        }
        ListNode fake = new ListNode(-1);
        ListNode point = fake;
        while(!pq.isEmpty()){
            point.next = pq.poll();
            point = point.next;
        }
        return fake.next;

    }


    @Self(thought = "cut & merge")
    public static ListNode sort(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // step 1. cut the list to two halves
        ListNode prev = null, slow = head, fast = head;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        ListNode l1 = sort(head);
        ListNode l2 = sort(slow);

        return merge(l1, l2);

    }

    public static ListNode merge(ListNode l1, ListNode l2){
        ListNode fake;
        fake = new ListNode(-1);
        ListNode point = fake;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                point.next = l1;
                l1 = l1.next;
            }else {
                point.next = l2;
                l2 = l2.next;
            }
            point = point.next;
        }
        if(l1 != null){
            point.next = l1;
        }
        if(l2 != null){
            point.next = l2;
        }
        return fake.next;
    }

    public static void main(String[] args){
        ListNode head = ListFactory.build(new int[]{99,5,32,6,34,6,23,76,587,354,213,62,43,64,124,124,6,47,346,234,0});
        ListFactory.print(sort(head));
        String s = "leetcode";
        System.out.println(s.substring(4, 8));
    }
}
