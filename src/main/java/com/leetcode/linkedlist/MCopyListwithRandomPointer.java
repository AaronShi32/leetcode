package com.topic.linkedlist;

import com.util.Question;
import com.util.Self;

import java.util.HashMap;
import java.util.Map;

@Question(id = 138, title = "Copy List with Random Pointer")
public class MCopyListwithRandomPointer {

    @Self(thought = "", complexity = "")
    static RandomListNode solution(RandomListNode head){
        if(head == null) return null;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();

        RandomListNode node = head;
        while (node != null){
            map.put(node, new RandomListNode(node.val));
            node = node.next;
        }

        node = head;
        while (node != null){
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }

        return map.get(head);
    }


    public static void main(String[] args){
        int h;
        System.out.println((h = 20) ^ (h >>> 16));

    }
}
