package com.leetcode.search;

import com.support.TreeNode;

import java.util.*;

public class MAllNodesDistanceKinBinaryTree {


    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> ans = new ArrayList<>();
        Map<TreeNode, TreeNode> map = new HashMap<>();
        find(root, null, map);
        dfs(target, K, ans, map, new HashSet<>());
        return ans;
    }

    private void dfs(TreeNode target, int K, List<Integer> ans, Map<TreeNode, TreeNode> map, HashSet<Object> visited) {
        if(target == null || K < 0 || visited.contains(target)){
            return;
        }

        if(K == 0){
            ans.add(target.val);
            return;
        }

        visited.add(target);
        dfs(target.left, K - 1, ans, map, visited);
        dfs(target.right, K - 1, ans, map, visited);
        dfs(map.get(target), K - 1, ans, map, visited);

    }

    private void find(TreeNode root, TreeNode parent, Map<TreeNode, TreeNode> map) {

        if(root == null){
            return;
        }

        map.put(root, parent);
        find(root.left, root, map);
        find(root.right, root, map);

    }


}
