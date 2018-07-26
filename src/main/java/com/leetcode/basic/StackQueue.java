package com.leetcode.basic;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列
 */
public class StackQueue {

    private Stack<Integer> s1 = new Stack<>();

    private Stack<Integer> s2 = new Stack<>();

    /**
     * 入栈
     * @param x
     */
    public void enqueue(int x){
        s1.push(x);
    }

    /**
     * 出栈
     * @return
     */
    public int dequeue(){
        // s2 不为空时不用倒, 直接用 s2.pop 即可
        if(s2.empty()){
            int count = s1.size();
            while(count != 1){
                s2.push(s1.pop());
                count --;
            }
            return s1.pop();
        } else {
            return s2.pop();
        }
    }
}
