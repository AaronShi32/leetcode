package com.topic.linkedlist;


import com.support.ListFactory;
import com.support.ListNode;
import com.util.Best;
import com.util.Question;
import com.util.Self;

@Question(id = 21, title = "Merge Two Sorted Lists")
public class EMergeTwoSortedLists {

    @Best
    @Self
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode fake = new ListNode(-1);
        ListNode point = fake;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                point.next = l1;
                l1 = l1.next;
            }else{
                point.next = l2;
                l2 = l2.next;
            }
            point = point.next;
        }
        if(l1 != null){
            point.next = l1;
        }
        if(l2 != null) {
            point.next = l2;
        }

        return fake.next;
    }



    public static void main(String[] args){
        ListNode l1 = ListFactory.build(new int[] {1, 2, 4});
        ListNode l2 = ListFactory.build(new int[] {1, 3, 4});
        ListNode m = mergeTwoLists(l1, l2);
        ListFactory.print(m);
    }
}
