package com.topic.linkedlist;

import com.support.ListFactory;
import com.support.ListNode;
import com.util.Question;
import com.util.Self;

import java.util.Stack;

@Question(id = 206, title = "Reverse Linked List", hint = "Reverse a singly linked list.")
public class EReverseLinkedList {

    @Self(thought = "stack", complexity = "")
    static ListNode solution(ListNode head){
        if(head == null)
            return null;
        Stack<ListNode> s = new Stack<ListNode>();
        ListNode point = head;
        while(point != null){
            s.push(new ListNode(point.val));
            point = point.next;
        }
        ListNode reverse = s.pop();
        point = reverse;
        while(!s.empty()){
            point.next = s.pop();
            point = point.next;
        }
        return reverse;
    }


    public static void main(String[] args){
        ListNode head = ListFactory.build(new int[]{1,2});
        ListFactory.print(solution(head));

    }
}
