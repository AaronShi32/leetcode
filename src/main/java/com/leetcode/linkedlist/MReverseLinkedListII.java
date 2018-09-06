package com.leetcode.linkedlist;

import com.support.ListFactory;
import com.support.ListNode;
import com.util.Idea;
import com.util.Self;

import java.util.Stack;

@Idea(use = "three point, pre, start, then: // 保持 pre, start 不动, then 拿出来插入 pre 和 start 中间")
public class MReverseLinkedListII {

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

    @Self(thought = "two pass exchange value use stack")
    static ListNode solution2(ListNode head, int m, int n){
        if(head == null)
            return null;

        ListNode fake = new ListNode(-1);
        fake.next = head;

        ListNode start = fake;

        for(int i = 0; i < m; i++){
            start = start.next;
        }

        Stack<Integer> value = new Stack<>();

        for(int i = 0; i < n - m + 1; i++){
            value.push(start.val);
            start = start.next;
        }

        start = fake;

        for(int i = 0; i < m; i++){
            start = start.next;
        }

        for(int i = 0; i < n - m + 1; i++){
            start.val = value.pop();
            start = start.next;
        }


        return fake.next;
    }


    public static void main(String[] args){
        ListNode head = ListFactory.build(new int[]{1,2,3,4,5});
        ListFactory.print(solution2(head,2 ,4));

    }
}
