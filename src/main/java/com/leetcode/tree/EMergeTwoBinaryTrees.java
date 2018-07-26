package com.topic.tree;

import com.support.TreeNode;
import com.util.Question;

@Question(id = 617, title = "Merge Two Binary Trees", hint = "" +
        "1. if two nodes overlap, then sum node values up as the new value of the merged node." +
        "2. the NOT null node will be used as the node of new tree.")
public class EMergeTwoBinaryTrees {

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) return null;
        else if(t1 == null) return t2;
        else if(t2 == null) return t1;
        TreeNode merge = new TreeNode(t1.val + t2.val);
        merge.left = mergeTrees(t1.left, t2.left);
        merge.right = mergeTrees(t1.right, t2.right);
        return merge;
    }


    public static void main(String[] args){

    }
}
