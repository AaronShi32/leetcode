package com.topic.tree;

import com.support.TreeNode;
import com.util.Question;

@Question(id = 226, title = "Invert Binary Tree", hint = "Invert a binary tree.")
public class EInvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;

        //Saving the nodes in temporary nodes before the values get overwritten
        TreeNode l = root.left;
        TreeNode r = root.right;

        root.left = invertTree(r); //Sending the right child to the left
        root.right = invertTree(l); //Sending the left child to the right

        return root;

    }

}
