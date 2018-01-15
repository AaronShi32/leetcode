package com.support;

public class ListFactory {

    public static ListNode build(int[] nodes){
        ListNode head = new ListNode(-1);
        ListNode point = head;
        int len = nodes.length;
        for(int i = 0; i < len; i++){
            ListNode node = new ListNode(nodes[i]);
            point.next = node;
            point = node;
        }
        return head.next;
    }

    public static void print(ListNode head){
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

}
