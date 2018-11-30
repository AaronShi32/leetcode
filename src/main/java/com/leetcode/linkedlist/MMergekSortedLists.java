package com.leetcode.linkedlist;

import com.support.ListFactory;
import com.support.ListNode;
import com.util.Best;
import com.util.Question;
import com.util.Self;

import java.util.Comparator;
import java.util.PriorityQueue;

@Question(id = 23, title = "Merge k Sorted Lists", hint = "Merge k sorted linked lists and return it as one sorted list")
public class MMergekSortedLists {

    @Best(thought = "use PriorityQueue(min heap)")
    @Self(thought = "miss")
    public static ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0)
            return null;

        PriorityQueue<ListNode> queue= new PriorityQueue<>(lists.length, Comparator.comparingInt(o -> o.val));

        ListNode fake = new ListNode(-1);
        ListNode point = fake;

        for (ListNode node: lists) // put add head
            if (node != null)
                queue.add(node);

        while (!queue.isEmpty()){  // when poll put next
            point.next = queue.poll();
            point = point.next;

            if (point.next!=null)
                queue.add(point.next);
        }
        return fake.next;
    }

    /**
     * 二分最优法, 递归
     * @param lists
     * @return
     */

    public static ListNode best(ListNode[] lists){
        if(lists == null || lists.length == 0)
            return null;
        return mergeKLists(lists, 0, lists.length - 1);
    }

    public static ListNode mergeKLists(ListNode[] lists, int start, int end){
        if(start == end) return lists[start];
        if(start + 1 == end) return merge2Lists(lists[start], lists[end]);

        int mid = start + (end - start) / 2;

        ListNode l1 = mergeKLists(lists, start, mid);
        ListNode l2 = mergeKLists(lists, mid + 1, end);

        return merge2Lists(l1, l2);
    }


    public static ListNode merge2Lists(ListNode l1, ListNode l2){
        ListNode fake = new ListNode(-1), point = fake;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                point.next = new ListNode(l1.val);
                l1 = l1.next;
            }else{
                point.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            point = point.next;
        }
        if(l1 == null)
            point.next = l2;
        else
            point.next = l1;
        return fake.next;
    }



    public static void main(String[] args){
        ListNode l1 = ListFactory.build(new int[]{2,3,4,8,9});
        ListNode l2 = ListFactory.build(new int[]{1,3,5,8,10});
        ListNode l3 = ListFactory.build(new int[]{-1,6,7,8,12});
        ListNode[] array = new ListNode[]{l1, l2, l3};
        ListFactory.print(best(array));
    }


}
