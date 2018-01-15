package com.topic.tree;

import com.support.TreeNode;
import com.util.Question;

import java.util.Stack;

@Question(id = 98, title = "Validate Binary Search Tree")
public class MValidateBinarySearchTree {

    public boolean solution(TreeNode root) {
        if(root == null)
            return true;
        Stack<TreeNode> s = new Stack<>();
        TreeNode tmp = root;
        TreeNode pre = null;
        while(tmp != null || !s.empty()){
            while(tmp != null){
                s.push(tmp);
                tmp = tmp.left;
            }
            if(!s.empty()){
                tmp = s.pop();
                if(pre != null && pre.val >= tmp.val) return false;
                pre = tmp;
                tmp = tmp.right;
            }
        }
        return true;
    }

    public static void main(String[] args){
        int h;
        System.out.println((h = 20) ^ (h >>> 16));

    }
}
