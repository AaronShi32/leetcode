package com;

import com.support.ListNode;
import com.support.TreeFactory;
import com.support.TreeNode;
import com.util.Date;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class Daily {

    @Date(d = "2018-01-31", title = "binary tree pre-order iteratively")
    public static void a1(TreeNode root){
        Stack<TreeNode> s = new Stack<>();
        TreeNode point = root;
        while(point != null || !s.empty()){
            while (point != null){
                s.push(point);
                System.out.print(point.val + " ");
                point = point.left;
            }
            if(!s.empty()){
                point = s.pop();
                point = point.right;
            }
        }
        return;
    }

    @Date(d = "2018-02-01", title = "binary tree in-order iteratively")
    public static void a2(TreeNode root){
        Stack<TreeNode> s = new Stack<>();
        TreeNode point = root;
        while(point != null || !s.empty()){
            while (point != null){
                s.push(point);
                point = point.left;
            }
            if(!s.empty()){
                point = s.pop();
                System.out.print(point.val + " ");
                point = point.right;
            }
        }
        return;
    }

    @Date(d = "2018-02-02", title = "valid parentheses")
    public static boolean a3(String s){
        Stack<Character> container = new Stack<>();
        for(Character c : s.toCharArray()){
            if(c == '(')
                container.push(')');
            else if(c == '[')
                container.push(']');
            else if(c == '{')
                container.push('}');
            else if(container.isEmpty() || c != container.pop()){
                return false;
            }
        }
        return container.isEmpty();
    }

    @Date(d = "2018-02-05", title = "linkedlist has cycle")
    public static boolean a4(ListNode head){
        if(head == null || head.next == null)
            return false;
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;

    }

    @Date(d = "2018-02-06", title = "quick sort")
    public static void a5(){
        int[] nums = {99,5,32,6,34,6,23,76,587,354,213,62,43,64,124,124,6,47,346,234,0};
        sort(nums, 0, nums.length - 1);
        System.out.print(Arrays.toString(nums));

    }

    private static void sort(int[] array, int start, int end){
        if(start < end){
            int partition = partition(array, start, end);
            sort(array, 0, partition - 1);
            sort(array, partition + 1, end);
        }
    }

    private static void swap(int[] array, int x, int y){
        int tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }

    private static int partition(int[] array, int start, int end){
        Random seed = new Random();
        int r = seed.nextInt(end - start) + start;
        swap(array, start, r);
        int guard = array[start];
        r = start;
        for(int i = start + 1; i <= end; i++){
            if(array[i] <= guard){
                r ++;
                swap(array, r, i); // i 在一直走, r 停在了最后一个小于哨兵的地方
            }
        }
        swap(array, start, r);
        return r;
    }

    @Date(d = "2018-02-07", title = "binary tree post-order iteratively")
    public static void a6(TreeNode root){
        Stack<TreeNode> s = new Stack<>();
        TreeNode cur, pre = null, tmp;

        s.push(root);

        while(!s.isEmpty()){
            cur = s.peek();
            if(cur.left == null && cur.right == null){
                System.out.print(cur.val + " ");
                tmp = s.pop();
                pre = cur;
            }
            else if(pre != null && (pre == cur.left || pre == cur.right)){
                System.out.print(cur.val + " ");
                tmp = s.pop();
                pre = cur;
            }
            else {
                if(cur.right != null){
                    s.push(cur.right);
                }
                if(cur.left != null){
                    s.push(cur.left);
                }
            }
        }
        return;
    }

    @Date(d = "2018-02-08", title = "sort list")
    public static void a7(){

    }

    @Date(d = "2018-02-09", title = "move zeroes")
    public static void a8(){

    }

    public static void main(String[] args){
        TreeNode root = TreeFactory.buildSample();
        a1(root);
        a2(root);
        System.out.print(a3("[]()[]{()}["));
        a5();
        a6(root);
    }
}
