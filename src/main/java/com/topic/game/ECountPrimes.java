package com.topic.game;

import com.util.Best;
import com.util.Question;
import com.util.Self;

@Question(id = 204, title = "Count Primes", hint = "" +
        "1. 素数")
public class ECountPrimes {

    @Best
    @Self
    public static int solution(int n){
        if(n <= 1 ) return 0;
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }

        return count;
    }

    public static void main(String[] args){
        System.out.println(solution(10));
    }
}
