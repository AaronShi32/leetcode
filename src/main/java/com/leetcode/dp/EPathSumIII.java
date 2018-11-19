package com.leetcode.dp;

import com.support.TreeNode;
import com.util.Question;

@Question(id = 437, title = "Path Sum III", hint = "" +
        "1. The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).")
public class EPathSumIII {

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int pathSumFrom(TreeNode node, int sum) {
        if (node == null) return 0;
        return (node.val == sum ? 1 : 0)
                + pathSumFrom(node.left, sum - node.val) + pathSumFrom(node.right, sum - node.val);
    }

}
