package com.leetcode.dp;

import com.support.TreeNode;
import com.util.Question;

@Question(id = 112, title = "Path Sum", hint = "" +
        "1. determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.")
public class EPathSum {

    public static boolean solution(TreeNode root, int sum){

        if(root == null) return false;

        if(root.left == null && root.right == null && sum - root.val == 0) return true;

        return solution(root.left, sum - root.val) || solution(root.right, sum - root.val);
    }

    public static void main(String[] args){

    }

}
