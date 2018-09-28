package com.leetcode.linkedlist;

import com.support.ListFactory;
import com.support.ListNode;
import com.util.Best;
import com.util.Question;
import com.util.Self;

@Question(id = 160, title = " Intersection of Two Linked Lists")
public class EIntersectionofTwoLinkedLists {

    @Best
    @Self
    public static ListNode solution(ListNode h1, ListNode h2){
        ListNode p1 = h1, p2 = h2;
        int len1 = 0, len2 = 0;
        while (p1 != null) {
            p1 = p1.next;
            len1++;
        }
        while (p2 != null) {
            p2 = p2.next;
            len2++;
        }
        p1 = h1;
        p2 = h2;
        if (len1 > len2) {
            for (int i = 0;i < len1 - len2; i++) {
                p1 = p1.next;
            }
        } else {
            for (int i = 0;i < len2 - len1; i++) {
                p2 = p2.next;
            }
        }
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    public static ListNode getIntersectionNode(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null){
            return null;
        }
        int len1 = 0, len2 = 0;
        for(ListNode node = l1; node != null; node = node.next){
            len1 ++;
        }
        for(ListNode node = l2; node != null; node = node.next){
            len2 ++;
        }
        if(len1 >= len2){
            int step = len1 - len2;
            ListNode p = l1;
            while(step != 0){
                p = p.next;
                step --;
            }
            for(ListNode q = l2; q != null; q = q.next){
                if(q == p){
                    return q;
                }else{
                    p = p.next;
                }
            }
        }else{
            return getIntersectionNode(l2, l1);
        }

        return null;
    }

    public static void main(String[] args){
        ListNode h1 = ListFactory.build(new int[]{1,3,5,7,9,11,13,15,17,19,21});
        ListNode h2 = ListFactory.build(new int[]{2});
        System.out.println(getIntersectionNode(h1, h2));
    }
}
