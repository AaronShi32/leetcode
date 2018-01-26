package com.topic.game;

import com.util.Best;
import com.util.Question;
import com.util.Self;

@Question(id = 7, title = "Reverse Integer")
public class EReverseInteger {

    @Best
    @Self(thought = "mod")
    public static int solution(int x){

        long r = 0;
        while(x != 0){
            r = r * 10 + x % 10;
            x = x / 10;
        }
        if(r > Integer.MAX_VALUE || r < Integer.MIN_VALUE){
            return 0;
        }
        return (int)r;

    }

    public static void main(String[] args){
        System.out.print(solution(131421321));
    }
}
