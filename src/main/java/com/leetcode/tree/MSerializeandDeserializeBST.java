package com.leetcode.tree;

import com.support.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MSerializeandDeserializeBST {


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return "#,";
        StringBuilder sb = new StringBuilder(root.val + ",");
        sb.append(serialize(root.left));
        sb.append(serialize(root.right));
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String str) {
        String[] nodes = str.split(",");
        Queue<String> q = new LinkedList<>();
        for(int i = 0; i < nodes.length; i++){
            q.offer(nodes[i]);
        }
        return preOrder(q);
    }

    private TreeNode preOrder(Queue<String> q) {
        String val = q.poll();
        if(val.equals("#"))
            return null;
        TreeNode root = new TreeNode(Integer.valueOf(val));
        root.left = preOrder(q);
        root.right = preOrder(q);
        return root;
    }


}
