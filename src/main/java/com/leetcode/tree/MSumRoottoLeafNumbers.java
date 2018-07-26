package com.topic.tree;

import com.support.TreeNode;
import com.util.Question;

@Question(id = 129, hint = "Find the total sum of all root-to-leaf numbers.")
public class MSumRoottoLeafNumbers {

    private static int total = 0;

    public static int sumNumbers(TreeNode root) {
        total = 0;
        helper(root, 0);
        return total;
    }

    public static void helper(TreeNode root, int sum) {
        if (root == null) return;

        sum = sum * 10 + root.val;

        if (root.left == null && root.right == null) {
            total += sum;
            return;
        }

        helper(root.left, sum);
        helper(root.right, sum);
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        System.out.println(sumNumbers(root));
    }

}
