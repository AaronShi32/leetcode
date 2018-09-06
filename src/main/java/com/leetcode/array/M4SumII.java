package com.leetcode.array;
import com.util.Best;
import com.util.Question;
import com.util.Self;

import java.util.HashMap;
import java.util.Map;


@Question(id = 454, title = "4Sum II", hint = "" +
        "1. compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero" +
        "2. all A, B, C, D have same length of N where 0 ≤ N ≤ 500")
public class M4SumII {


    @Best(thought = "map<sum ,times> and divide-and-conquer", complexity = "O(n2)")
    static int leetcode(int[] A, int[] B, int[] C, int[] D){
        Map<Integer, Integer> map = new HashMap<>();
        int len = A.length;
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                int sum = A[i] + B[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        int tuples = 0;
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                tuples += map.getOrDefault(-1 * (C[i] + D[j]), 0);
            }
        }
        return tuples;
    }

    @Self(thought = "Time Limit Exceeded", complexity = "O(n4)")
    static int solution(int[] A, int[] B, int[] C, int[] D){
        int tuples = 0, len = A.length, target = 0;
        for(int iA = 0; iA < len; iA++){
            for(int iB = 0; iB < len; iB++){
                for(int iC = 0; iC < len; iC++){
                    for(int iD = 0; iD < len; iD++){
                        int sum = A[iA] + B[iB] + C[iC] + D[iD];
                        if(sum == 0){
                            tuples ++;
                            System.out.println(iA + ", " + iB + ", " + iC + ", " + iD);
                        }
                    }
                }
            }
        }

        return tuples;
    }


    public static void main(String[] args){
        int[] A = {1,2};
        int[] B = {-2,-1};
        int[] C = {-1,2};
        int[] D = {0,2};
        System.out.println(solution(A, B, C, D));
    }

}
