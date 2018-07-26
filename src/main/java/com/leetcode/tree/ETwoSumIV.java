package com.topic.tree;

import com.support.TreeNode;
import com.util.Best;
import com.util.Question;
import com.util.Self;

import java.util.HashSet;

@Question(id= 653, title = "Two Sum IV ", hint = "" +
        "1. Given a Binary Search Tree and a target number" +
        "2. return true if there exist two elements in the BST such that their sum is equal to the given target.")
public class ETwoSumIV {

    @Best(thought = "use Set to save")
    @Self(thought = "miss")
    public static boolean solution(TreeNode root, int k){
        HashSet<Integer> set = new HashSet<>();
        return dfs(root, set, k);
    }

    private static boolean dfs(TreeNode root, HashSet<Integer> set, int k){
        if(root == null) return false;
        if(set.contains(k - root.val)) return true;
        set.add(root.val);
        return dfs(root.left, set, k) || dfs(root.right, set, k);
    }

    public static void main(String[] args){

    }
}
