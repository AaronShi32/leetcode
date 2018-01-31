package com;

import com.support.TreeFactory;
import com.support.TreeNode;
import com.util.Date;

import java.util.Stack;

public class Daily {

    @Date(d = "2018-01-31", title = "binary tree pre-order iteratively")
    public static void a1(TreeNode root){
        Stack<TreeNode> s = new Stack<>();
        TreeNode point = root;
        while(point != null || !s.empty()){
            while (point != null){
                s.push(point);
                System.out.print(point.val + " ");
                point = point.left;
            }
            if(!s.empty()){
                point = s.pop();
                point = point.right;
            }
        }
        return;
    }


    public static void main(String[] args){
        TreeNode root = TreeFactory.buildSample();
        a1(root);
    }
}
