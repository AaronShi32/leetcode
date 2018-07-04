package com.topic.tree;

import com.support.TreeNode;
import com.util.Question;

import java.util.HashMap;
import java.util.Map;

@Question(id = 230, hint = "Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.")
public class MKthSmallestElementinaBST {

    private int index = 0;

    private Map<Integer, Integer> map = new HashMap<>();

    public int kthSmallest(TreeNode root, int k) {
        inorder(root);
        return map.get(k);
    }

    private void inorder(TreeNode node){
        if(node == null){
            return;
        }
        inorder(node.left);
        map.put(++ index, node.val);
        inorder(node.right);
    }

}
