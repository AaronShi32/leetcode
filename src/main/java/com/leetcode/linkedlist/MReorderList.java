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

    public static void reorderListDeque(ListNode head) {

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


    // 断链需要有 pre = null 这一步
    public static void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)
            return;

        ListNode slow = head, fast = head, pre = null, l1 = head;
        while(fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        pre.next = null;

        ListNode l2 = reverse(slow);

        merge(l1, l2);

    }

    private static ListNode reverse(ListNode head){
        ListNode pre = null;
        while(head != null){
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        return pre;
    }

    private static void merge(ListNode l1, ListNode l2){
        while (l1 != null) {
            ListNode n1 = l1.next, n2 = l2.next;
            l1.next = l2;
            if (n1 == null) // 奇数链: l1 比 l2 长度 + 1, 因此以 l1 作为判断
                break;
            l2.next = n1;
            l1 = n1;
            l2 = n2;
        }
        return;
    }

    public static void main(String[] args){
        ListNode head = ListFactory.build(new int[]{1,2,3,4,5});
        reorderList(head);
        ListFactory.print(head);
    }
}
