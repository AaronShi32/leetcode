package com.topic.linkedlist;

import com.support.TreeFactory;
import com.support.TreeNode;
import com.topic.tree.TraverseNonRecursion;
import com.util.Question;

import java.util.Stack;

@Question(id = 114, title = "Flatten Binary Tree to Linked List", hint = "pre-order")
public class MFlattenBinaryTreetoLinkedList {

    public static void flatten(TreeNode root) {
        flatten(root,null);
    }

    private static TreeNode flatten(TreeNode root, TreeNode pre) {
        if(root == null)
            return pre;
        pre = flatten(root.right, pre);
        pre = flatten(root.left, pre);
        root.right = pre;
        root.left = null;
        pre = root;
        return pre;
    }


    public static void main(String[] args){
        TreeNode root = TreeFactory.buildSample();
        flatten(root);
    }

}
