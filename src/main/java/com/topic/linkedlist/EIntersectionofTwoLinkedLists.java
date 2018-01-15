package com.topic.linkedlist;

import com.support.ListNode;
import com.util.Best;
import com.util.Question;
import com.util.Self;

@Question(id = 160, title = " Intersection of Two Linked Lists")
public class EIntersectionofTwoLinkedLists {

    @Best
    @Self
    public ListNode solution(ListNode h1, ListNode h2){
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
}
