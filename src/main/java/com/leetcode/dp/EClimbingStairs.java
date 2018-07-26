package com.topic.dp;

import com.util.Best;
import com.util.Question;
import com.util.Self;

import java.util.ArrayList;
import java.util.List;

@Question(id = 70, title = "Climbing Stairs", hint = "" +
        "1. It takes n steps to reach to the top." +
        "2. Each time you can either climb 1 or 2 steps." +
        "3. how many distinct ways can you climb to the top?")
public class EClimbingStairs {

    @Best
    @Self(thought = "fibonacci")
    public static int solution(int n){
        if(n == 0 || n == 1 || n == 2){return n;}
        int[] mem = new int[n];
        mem[0] = 1;
        mem[1] = 2;
        for(int i = 2; i < n; i++){
            mem[i] = mem[i-1] + mem[i-2];
        }
        return mem[n-1];
    }


    public static void main(String[] args){

    }
}
