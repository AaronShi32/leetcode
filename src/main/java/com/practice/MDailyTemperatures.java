package com.topic.interview;

import java.util.Arrays;
import java.util.Stack;

public class MDailyTemperatures {

    public static int[] dailyTemperatures(int[] a) {
        int count = a.length;
        int[] ans = new int[count];
        for(int i = 0; i < count; i++){
            for(int j = i + 1; j < count; j++){
                if(a[j] > a[i]){
                    ans[i] = (j - i);
                    break;
                }
            }
        }

        return ans;
    }

    public static int[] leetCode(int[] a){
        Stack<Integer> stack = new Stack<>();
        int[] ret = new int[a.length];
        for(int i = 0; i < a.length; i++) {
            while(!stack.isEmpty() && a[i] > a[stack.peek()]) {
                int idx = stack.pop();
                ret[idx] = i - idx;
            }
            stack.push(i);
        }
        return ret;
    }

    public static void main(String[] args){
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(leetCode(temperatures)));

    }

}
