package com.leetcode.prime;

import com.support.TreeFactory;
import com.support.TreeNode;

import java.util.Stack;

public class MInorderSuccessorinBST {

    // 寻找BST中序遍历的后继元素
    public static TreeNode inOrderSuccessor(TreeNode root, int val){
        if(root == null){
            return null;
        }
        Stack<TreeNode> s = new Stack<>();
        boolean pre = false;
        while(root != null || !s.isEmpty()){
            while(root != null){
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            if(pre){
                return root;
            }
            if(root.val == val)
                pre = true;
            root = root.right;
        }
        return null;
    }

    public static void main(String[] args){
        TreeNode root = TreeFactory.buildBST();
        System.out.println(inOrderSuccessor(root, 2).val);
    }
}
