package com.leetcode.tree;

import com.support.TreeNode;
import com.util.Question;

@Question(id = 104, title = "Maximum Depth of Binary Tree", hint = "" +
        "1. Maximum" +
        "2. Minimum")
public class EMaximumDepthofBinaryTree {

    public static int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null){
            return minDepth(root.right) + 1;
        }
        if(root.right == null){
            return minDepth(root.left) + 1;
        }
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

}
