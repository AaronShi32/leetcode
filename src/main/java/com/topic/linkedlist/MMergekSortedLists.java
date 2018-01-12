package com.topic.linkedlist;

import com.util.Question;

import java.util.Comparator;
import java.util.PriorityQueue;

@Question(id = 23, title = "Merge k Sorted Lists", hint = "Merge k sorted linked lists and return it as one sorted list")
public class MMergekSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0)
            return null;

        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.length,()->{
            @Override
            public int compare(ListNode o1,ListNode o2){
                if (o1.val < o2.val)
                    return -1;
                else if (o1.val == o2.val)
                    return 0;
                else
                    return 1;
            }
        });

        ListNode fake = new ListNode(-1);
        ListNode point = fake;

        for (ListNode node:lists)
            if (node != null)
                queue.add(node);

        while (!queue.isEmpty()){
            point.next=queue.poll();
            point = point.next;

            if (point.next!=null)
                queue.add(point.next);
        }
        return fake.next;
    }


}
