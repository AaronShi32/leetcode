package com.contest;

import com.support.TreeNode;

import java.util.*;

public class MLCA {

    // common binary tree
    public TreeNode lca(TreeNode root, TreeNode p, TreeNode q){

        Map<TreeNode, TreeNode> map = new HashMap<>(); //child - parent
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        map.put(root, null);

        while(!map.containsKey(p) || !map.containsKey(q)){
            TreeNode node = queue.poll();
            if(node != null) {
                queue.offer(node.left);
                queue.offer(node.right);
                map.put(node.left, node);
                map.put(node.right, node);
            }
        }

        Set<TreeNode> s = new HashSet<>();
        while(p != null){
            s.add(p);
            p = map.get(p);
        }
        while(!s.contains(q)){
            q = map.get(q);
        }
        return q;
    }

    // bst
    public TreeNode lcab(TreeNode root, TreeNode p, TreeNode q){
        if(root.val > p.val && root.val > q.val){
            return lcab(root.left, p, q);
        }else if(root.val < p.val && root.val < p.val){
            return lcab(root.right, p, q);
        }else {
            return root;
        }
    }



}
