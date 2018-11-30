package com.leetcode.prime;

import com.support.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MBoundaryofBinaryTree {

    public static List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        if (root.left != null || root.right != null) {
            list.add(root.val);
        }
        findLeft(root.left, list);
        findLeaves(root, list);
        findRight(root.right, list);
        return list;
    }

    private static void findLeft(TreeNode root, List<Integer> res) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        res.add(root.val);
        if (root.left != null) {
            findLeft(root.left, res);
        } else {
            findLeft(root.right, res);
        }
    }

    private static void findRight(TreeNode root, List<Integer> res) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        res.add(root.val);
        if (root.right != null) {
            findRight(root.right, res);
        } else {
            findRight(root.left, res);
        }
    }

    private static void findLeaves(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            res.add(root.val);
        }
        findLeaves(root.left, res);
        findLeaves(root.right, res);
    }
}
