package com.leetcode;

import com.support.TreeFactory;
import com.support.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Main {


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "#,";
        StringBuilder sb = new StringBuilder(root.val + ",");
        sb.append(serialize(root.left));
        sb.append(serialize(root.right));
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        Queue<String> q = new LinkedList<>();
        for(int i = 0; i < nodes.length; i++){
            q.offer(nodes[i]);
        }
        return preOrder(q);
    }

    private TreeNode preOrder(Queue<String> q){
        String val = q.poll();
        if(val.equals("#"))
            return null;
        TreeNode root = new TreeNode(Integer.valueOf(val));
        root.left = preOrder(q);
        root.right = preOrder(q);
        return root;
    }


    public static void main(String[] args){
        Main ins = new Main();
        String ser = ins.serialize(TreeFactory.buildBST());
        System.out.println(ser);
        System.out.println(ins.deserialize(ser));

    }
}
