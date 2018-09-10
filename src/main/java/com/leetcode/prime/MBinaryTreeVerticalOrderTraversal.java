package com.leetcode.prime;

import com.support.TreeNode;

import java.util.*;

public class MBinaryTreeVerticalOrderTraversal {


    class ColumnTreeNode {
        TreeNode node;
        int column;
        public ColumnTreeNode(TreeNode node, int column){
            this.node = node;
            this.column = column;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Map<Integer, List<Integer>> map = new HashMap<>(); // column - List<node.val>
        Queue<ColumnTreeNode> q = new LinkedList<>();
        q.offer(new ColumnTreeNode(root, 0));

        while(!q.isEmpty()){
            ColumnTreeNode node = q.poll();
            if(!map.containsKey(node.column)){
                map.put(node.column, new ArrayList<>());
            }
            List<Integer> list = map.get(node.column);
            list.add(node.node.val);
            if(node.node.left != null)
                q.offer(new ColumnTreeNode(node.node.left, node.column - 1));
            if(node.node.right != null)
                q.offer(new ColumnTreeNode(node.node.right, node.column + 1));
        }

        List<Integer> columns = new ArrayList<>(map.keySet());
        Collections.sort(columns);

        for(int i = 0; i < columns.size(); i++){
            ans.add(map.get(columns.get(i)));
        }

        return ans;
    }
}
