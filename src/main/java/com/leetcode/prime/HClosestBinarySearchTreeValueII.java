package com.leetcode.prime;

import com.support.TreeFactory;
import com.support.TreeNode;
import com.util.Self;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class HClosestBinarySearchTreeValueII {

    @Self
    public static List<Integer> closestBSTValue(TreeNode root, float target, int k){

        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Stack<TreeNode> stack = new Stack<>();
        float gap = 0, pre = 0;
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(ans.size() == k){

                float g = Math.abs(root.val - target);
                if(g < gap){
                    ans.remove(0);
                    ans.add(root.val);
                }

                gap = pre;

            }else{
                pre = gap;
                gap = Math.max(gap, Math.abs(target - root.val));
                ans.add(root.val);
            }
            root = root.right;
        }

        return ans;

    }

    public static void main(String[] args){
        TreeNode root = TreeFactory.buildBST();
        System.out.println(closestBSTValue(root, 6.6f, 2));
    }


}
