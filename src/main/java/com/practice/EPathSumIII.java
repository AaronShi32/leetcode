package com.practice;

import com.support.TreeNode;
import com.util.Question;

import java.util.HashMap;
import java.util.Map;

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


    public int pathSumIII(TreeNode root, int target){

        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        return dfs(root, 0, target, preSum);

    }

    private int dfs(TreeNode root, int currSum, int target, Map<Integer, Integer> preSum) {
        if(root == null) return 0;

        currSum += root.val;

        int res = preSum.getOrDefault(currSum - target, 0);

        preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);

        res += dfs(root.left, currSum, target, preSum);
        res += dfs(root.right, currSum, target, preSum);

        preSum.put(currSum, preSum.get(currSum) - 1);
        return res;
    }

    public static void main(String[] args){
        int h;
        System.out.println((h = 20) ^ (h >>> 16));
    }

}
