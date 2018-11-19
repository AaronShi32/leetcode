package com.practice;

import com.support.TreeNode;
import com.util.Question;

@Question(id = 437, title = "Path Sum III", hint = "" +
        "1. find the total number of continuous subarrays whose sum equals to k")
public class EPathSumIII {

    public int pathSum(TreeNode root, int target) {
        if(root == null)
            return 0;
        return walk(root, target) + walk(root.left, target) + walk(root.right, target);
    }

    private int walk(TreeNode n, int target){
        if(n == null){
            return 0;
        }
        int count = 0;
        if(target == 0){
            count = 1;
        }
        return count + walk(n.left, target - n.val) + walk(n.right, target - n.val);
    }

    public static void main(String[] args){
        int h;
        System.out.println((h = 20) ^ (h >>> 16));
    }

}
