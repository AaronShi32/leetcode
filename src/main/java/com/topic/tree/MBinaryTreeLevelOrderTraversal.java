package com.topic.tree;

import com.support.TreeNode;
import com.util.Question;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Question(id = 102)
public class MBinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ret = new ArrayList<>();

        levelOrderHelper(root, ret, 0);

        return ret;
    }

    private void levelOrderHelper(TreeNode node, List<List<Integer>> ret, int level) {

        if (node == null) return;
        if (ret.size() == level) ret.add(new LinkedList<Integer>());

        ret.get(level).add(node.val);

        level++;
        levelOrderHelper(node.left, ret, level);
        levelOrderHelper(node.right, ret, level);
    }

    public static void main(String[] args){

    }

}
