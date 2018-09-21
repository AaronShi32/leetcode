package com.leetcode.linkedlist;

import com.support.ListFactory;
import com.support.ListNode;
import com.support.TreeNode;

public class MSortedListToBST {

    public static TreeNode sortedListToBST(ListNode head) {
        if(head == null)
            return null;
        ListNode fake = new ListNode(-1);
        fake.next = head;
        ListNode slow = head, fast = head, pre = fake;
        while(fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode partition = slow.next;
        pre.next = null;
        slow.next = null;
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(partition);
        return root;
    }

    public static void main(String[] args){
        ListNode head = ListFactory.build(new int[]{-10, -3, 0, 5, 9});
        sortedListToBST(head);
    }
}
