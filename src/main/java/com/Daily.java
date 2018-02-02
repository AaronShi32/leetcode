package com;

import com.support.ListNode;
import com.support.TreeFactory;
import com.support.TreeNode;
import com.util.Date;

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
    public static void a4(ListNode head){

    }

    @Date(d = "2018-02-06", title = "quick sort")
    public static void a5(int[] nums){

    }

    @Date(d = "2018-02-07", title = "binary tree post-order iteratively")
    public static void a6(int[] nums){

    }

    public static void main(String[] args){
        TreeNode root = TreeFactory.buildSample();
        a1(root);
        a2(root);
        System.out.print(a3("[]()[]{()}["));
    }
}
