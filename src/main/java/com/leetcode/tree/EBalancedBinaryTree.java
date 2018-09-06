package com.leetcode.tree;

import com.support.TreeNode;
import com.util.Question;

@Question(id = 110, title = "Balanced Binary Tree", hint = "" +
        "Given a binary tree, determine if it is height-balanced.")
public class EBalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        return root == null ? true : (Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right));
    }

    public int depth(TreeNode root){
        return root == null ?  0 : Math.max(depth(root.left), depth(root.right)) + 1;
    }
}
