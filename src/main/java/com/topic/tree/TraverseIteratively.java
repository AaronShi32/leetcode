package com.topic.tree;

import com.support.TreeFactory;
import com.support.TreeNode;

import java.util.*;

public class TraverseIteratively {

    public static void preOrder(TreeNode root){
        Stack<TreeNode> s = new Stack<>();
        TreeNode tmp = root;
        while(tmp != null || !s.empty()){
            while(tmp != null){
                s.push(tmp);
                System.out.print(tmp.val + " ");
                tmp = tmp.left;
            }
            if(!s.empty()){
                tmp = s.pop();
                tmp = tmp.right;
            }
        }
    }

    public static void inOrder(TreeNode root){
        Stack<TreeNode> s = new Stack<>();
        TreeNode tmp = root;
        while(tmp != null || !s.empty()){
            while (tmp != null){
                s.push(tmp);
                tmp = tmp.left;
            }
            if(!s.empty()){
                tmp = s.pop();
                System.out.print(tmp.val + " ");
                tmp = tmp.right;
            }
        }
    }

    public static void postOrder(TreeNode root){
        Stack<TreeNode> s = new Stack<>();
        s.push(root);

        TreeNode cur, pre = null, tmp;

        while(!s.empty()){
            cur = s.peek();
            if(cur.left == null && cur.right == null){
                System.out.print(cur.val + " ");
                tmp = s.pop();
                pre = cur;
            }else if(pre != null && (pre == cur.left || pre == cur.right)){
                System.out.print(cur.val + " ");
                tmp = s.pop();
                pre = cur;
            }else{
                if(cur.right != null){
                    s.push(cur.right);
                }
                if(cur.left != null){
                    s.push(cur.left);
                }
            }
        }
    }

    public static void levelOrder(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> wrapList = new LinkedList<>();

        queue.offer(root);

        while(!queue.isEmpty()){
            int level = queue.size();

            List<Integer> subList = new LinkedList<>();

            for(int i = 0; i < level; i++) {
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                subList.add(queue.poll().val);
            }
            wrapList.add(subList);
        }
        System.out.println(wrapList);
    }

    public static void main(String[] args){
        TreeNode root = TreeFactory.buildSample();
        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
    }

}
