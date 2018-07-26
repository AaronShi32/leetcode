package com.topic.tree;

import com.support.TreeNode;
import com.util.Question;

@Question(id = 404, hint = "Find the sum of all left leaves in a given binary tree.")
public class ESumofLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        int res = 0;
        if(root == null) return res;
        if(isLeftLeaf(root.left)) res += root.left.val;
        return res + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

    private boolean isLeftLeaf(TreeNode node){
        return node != null && node.left == null && node.right == null;
    }

}
