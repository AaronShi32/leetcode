package com.topic.tree;

import com.support.TreeNode;
import com.util.Question;

@Question(id = 129, hint = "Find the total sum of all root-to-leaf numbers.")
public class MSumRoottoLeafNumbers {

    public int sumNumbers(TreeNode root) {
        if(root == null){
            return -1;
        }
        return sum(root.left) + sum(root.right);
    }

    private int sum(TreeNode node){
        return 0;
    }

}
