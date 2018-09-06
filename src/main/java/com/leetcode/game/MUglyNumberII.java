package com.leetcode.game;

import com.util.Idea;

@Idea(use = "dp")
public class MUglyNumberII {

    public static int nthUglyNumber(int n) {
        int count = 1;
        if(n == 1){
            return count;
        }
        for(int i = 2; ; i++){
            if(i % 2 == 0 || i % 3 == 0 || i % 5 == 0){
                count++;
                if(count == n){
                    return i;
                }
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(11));
    }
}
