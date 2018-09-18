package com.leetcode.tree;

import com.support.TreeNode;

public class MMaximumBinaryTree {

    // nums = {3, 2, 1, 6, 0, 5}
    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }
        return construct(nums, 0, nums.length - 1);
    }


    private static TreeNode construct(int[] nums, int start, int end){
        if(start > end){
            return null;
        }
        int max = -1, k = 0;
        for(int i = start; i <= end; i++){
            if(max < nums[i]){
                max = nums[i];
                k = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = construct(nums, start, k - 1);
        root.right = construct(nums, k + 1, end);
        return root;
    }

    public static void main(String[] args){
        int[] nums = {3, 2, 1, 6, 0, 5};
        TreeNode root = constructMaximumBinaryTree(nums);
    }

}
