package com.topic.dfs;

import com.util.Best;
import com.util.Question;
import com.support.TreeNode;
import com.util.Self;

import java.util.ArrayList;
import java.util.List;

@Question(id = 113, title = "Path Sum II", hint = "" +
        "1. Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.")
public class MPathSumII {

    @Best
    @Self(thought = "dfs")
    public List<List<Integer>> solution(TreeNode root, int target){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> record = new ArrayList<>();
        backtrack(result, record, root, target);
        return result;
    }

    private boolean isleaf(TreeNode node){
        return node.left == null && node.right == null;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> record, TreeNode root, int target){
        if(root == null)
            return;
        record.add(root.val);
        if(isleaf(root) && target == root.val){ // bingo
            result.add(new ArrayList<>(record));
        } else {
            backtrack(result, record, root.left, target - root.val);
            backtrack(result, record, root.right, target - root.val);
        }
        record.remove(record.size() - 1);
    }

    public static void main(String[] args){

    }
}
