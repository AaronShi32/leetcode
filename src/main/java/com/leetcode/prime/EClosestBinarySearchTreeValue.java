package com.leetcode.prime;

import com.support.TreeFactory;
import com.support.TreeNode;

import java.util.Stack;

public class EClosestBinarySearchTreeValue {

    public static TreeNode closetSearchBST(TreeNode root, float val){
        if(root == null){
            return null;
        }
        Stack<TreeNode> s = new Stack<>();
        float min = val;
        TreeNode closeNode = null;
        while(root != null || !s.isEmpty()){
            while(root != null){
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            if(Math.abs(root.val - val) < min){
                min = Math.abs(root.val - val);
                closeNode = root;
            }
            root = root.right;
        }
        return closeNode;
    }

    public static void main(String[] args){
        TreeNode root = TreeFactory.buildBST();
        System.out.println(closetSearchBST(root, 4.414286f).val);
    }
}
