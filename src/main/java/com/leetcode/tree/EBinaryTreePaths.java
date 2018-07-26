package com.topic.tree;

import com.support.TreeNode;
import com.util.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@Question(id = 257, title = "Binary Tree Paths", hint = "" +
        "1. Given a binary tree, return all root-to-leaf paths.")
public class EBinaryTreePaths {

    public List<String> solution(TreeNode root) {
        List<String> path = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtrack(path, sb, root);
        return path;
    }

    private boolean isleaf(TreeNode node){
        return node.left == null && node.right == null;
    }

    private void backtrack(List<String> path, StringBuilder record, TreeNode root){
        if(root == null){
            return;
        }
        int len = record.length();
        record.append(root.val);
        if(isleaf(root)){
            path.add(record.toString());
        }else{
            record.append("->");
            backtrack(path, record, root.left);
            backtrack(path, record, root.right);
        }
        record.setLength(len); // backtrack
    }

    public static void main(String[] args){

    }
}
