package com.topic.game;

import com.util.Best;
import com.util.Question;
import com.util.Self;

@Question(id = 461, title = "Hamming Distance")
public class EHammingDistance {

    @Best(thought = "jdk: Integer.bitCount")
    public static int solution(int x, int y){
        return Integer.bitCount(x ^ y);
    }

    @Self(thought = "xor")
    public static int leetcode(int x, int y){
        int xor = x ^ y;
        int res = 0;
        while(xor != 0) {
            res += xor & 1;
            xor >>= 1;
        }
        return res;
    }
}
