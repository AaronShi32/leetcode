package com.leetcode.tree;

import com.support.TreeNode;
import com.util.Question;

import java.util.ArrayList;
import java.util.List;

@Question(id = 257, title = "Binary Tree Paths", hint = "" +
        "1. Given a binary tree, return all root-to-leaf paths.")
public class EBinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> answer = new ArrayList<>();
        if (root != null) searchBT(root, "", answer);
        return answer;
    }
    private void searchBT(TreeNode root, String path, List<String> answer) {
        if (root.left == null && root.right == null) answer.add(path + root.val);
        if (root.left != null) searchBT(root.left, path + root.val + "->", answer);
        if (root.right != null) searchBT(root.right, path + root.val + "->", answer);
    }

    public static void main(String[] args){

    }
}
