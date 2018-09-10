package com.contest;

public class NumbersAtMostNGivenDigitSet {

    private static int count = 0;

    // res = Math.pow(D.length, n(for 1...n(bit))) + < N(length)
    public static int atMostNGivenDigitSet(String[] D, int N) {
        int ans = 0, base = D.length;
        int[] r = bit(N);
        int quo = r[0], mod = r[1];
        for(int i = 1; i < quo; i++){
            ans += Math.pow(base, i);
        }
        if(mod == 0){
            return ans;
        }
        backtracking(D, N, quo, "");
        return ans + count;
    }

    private static int[] bit(int N){
        int quo = 0, mod = 0;
        int num = N;
        while(num != 0){
            num = num / 10;
            quo ++;
        }
        mod = N % (int) Math.pow(10, quo);
        return new int[]{quo, mod};
    }

    private static void backtracking(String[] digit, int target, int len, String res){
        if(res.length() == len && Integer.valueOf(res) <= target){
            count ++;
            return;
        }
        if(res.length() > len){
            return;
        }
        for(int i = 0; i < digit.length; i++){
            res += digit[i];
            backtracking(digit, target, len, res);
            res = res.substring(0, res.length() - 1);
        }
    }

    public static void main(String[] args){
        String[] digit = {"5", "7", "8"};
        atMostNGivenDigitSet(digit, 59);
        //backtracking(digit, 0, 236, 3, "");
        System.out.println(count);
    }

}
