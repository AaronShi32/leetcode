package com.leetcode.linkedlist;

import com.support.ListFactory;
import com.support.ListNode;

public class Basic {

    // 全部反转
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



    // 转换区间: (start, end) 不包含两侧
    private static ListNode reverseBetween(ListNode start, ListNode end){
        ListNode pre = start;
        ListNode cur = start.next, first = cur;
        ListNode then;
        while (cur != end){
            then = cur.next;
            cur.next = pre;
            pre = cur;
            cur = then;
        }
        start.next = pre; // 反转连接首尾
        first.next = cur; // 反转连接首尾
        return first;
    }

    public static void main(String[] args){
        ListNode head = ListFactory.build(new int[]{1,5,7,8,12,34,6,72});
        //ListFactory.print(reverse(head));

        ListNode start = head.next; // 2
        ListNode end = head.next.next.next.next.next; // 12
        start = reverseBetween(start, end);
        ListFactory.print(head);
    }
}
