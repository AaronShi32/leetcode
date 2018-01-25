package com.topic.tree;

import com.support.TreeFactory;
import com.support.TreeNode;
import com.util.Question;

@Question(id = 100, title = "Same Tree")
public class ESameTree {

    public static boolean solution(TreeNode p, TreeNode q){
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val == q.val)
            return solution(p.left, q.left) && solution(p.right, q.right);
        return false;
    }

    public static void main(String[] args){
        //System.out.print(solution(TreeFactory.buildSample(), TreeFactory.buildSample()));
        Integer a = 1;
        Integer b = 1;
        System.out.println(a == b);
    }
}
