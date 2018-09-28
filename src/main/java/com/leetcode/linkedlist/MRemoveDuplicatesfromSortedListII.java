package com.leetcode.linkedlist;

import com.support.ListNode;
import com.util.Question;

import java.util.*;

@Question(id = 82, hint = "Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.")
public class MRemoveDuplicatesfromSortedListII {

    public static ListNode deleteDuplicatesSolution1(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }

        Map<Integer, ArrayList<ListNode>> bucket = new HashMap<>();
        ListNode cur = head;
        while(cur != null){
            ArrayList<ListNode> n = bucket.getOrDefault(cur.val, new ArrayList<>());
            n.add(cur);
            bucket.put(cur.val, n);
            cur = cur.next;
        }

        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for(Integer key: bucket.keySet()){
            if(bucket.get(key).size() == 1){
                queue.add(bucket.get(key).get(0));
            }
        }

        ListNode fake = new ListNode(-1);
        ListNode point = fake;
        while(!queue.isEmpty()){
            point.next = queue.poll();
            point = point.next;
        }

        return fake.next;


    }

    public ListNode deleteDuplicatesSolution2(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }

        boolean needRemoveHead = (head.val == head.next.val);

        ListNode cur = head;

        while(cur != null && cur.next != null && cur.next.next!=null){
            if(cur.next.val == cur.next.next.val){
                int val = cur.next.val;
                ListNode temp = cur.next;
                while(temp != null && temp.val == val){
                    temp = temp.next;
                }
                cur.next = temp;
            } else {
                cur = cur.next;
            }
        }

        if(needRemoveHead){
            if(head != null && head.next != null && head.val == head.next.val)
                return head.next.next;
            return head.next;
        }
        return head;
    }


    public static void main(String[] args){
        int[] array = {1, 2, 3, 3, 4, 4, 5};
        ListNode fake = new ListNode(-1);
        ListNode point = fake;
        for(int i : array){
            point.next = new ListNode(i);
            point = point.next;
        }
        deleteDuplicatesSolution1(fake.next);


        String str = "1,2,3,,";
        System.out.println(str.split(",").length);
    }

}
