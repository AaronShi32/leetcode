package com.topic.tree;

import com.support.TreeNode;
import com.util.Question;

import java.util.LinkedList;
import java.util.Queue;

@Question(id = 101, title = "Symmetric Tree", hint = "" +
        "1. Given a binary tree, check whether it is a mirror of itself")
public class ESymmetricTree {

    public boolean solution(TreeNode root) {
        if(root == null) return true;
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        return (p.val == q.val) && isMirror(p.left, q.right) && isMirror(p.right, q.left);
    }


    public boolean iteratively(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null) return true;
        q.add(root.left);
        q.add(root.right);
        while(q.size() > 1){
            TreeNode left = q.poll(),
                    right = q.poll();
            if(left == null && right == null) continue;
            if(left == null || right == null) return false;
            if(left.val != right.val) return false;
            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);
        }
        return true;
    }

    public static void main(String[] args){

    }

}
