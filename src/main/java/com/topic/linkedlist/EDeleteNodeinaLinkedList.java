package com.topic.linkedlist;

import com.util.Best;
import com.util.Question;
import com.util.Self;

@Question(id = 237, title = "Delete Node in a Linked List")
public class EDeleteNodeinaLinkedList {

    @Best
    @Self(complexity = "O(n)")
    static void solution(ListNode node){
        node.val = node.next.val;
        node.next = node.next.next;
    }


    public static void main(String[] args){

    }
}
