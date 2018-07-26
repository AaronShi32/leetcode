package com.topic.string;

import com.util.Best;
import com.util.Question;
import com.util.Self;

import java.util.Stack;

@Question(id = 394, title = "Decode String", hint = "" +
        "1. rule is: k[encoded_string]" +
        "2. No extra white spaces, square brackets are well-formed")
public class MDecodeString {

    @Best
    @Self(thought = "two stack")
    public static String decodeString(String s) {
        if(s == null || s.length() == 0){
            return s;
        }
        Stack<Integer> intStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder decode = new StringBuilder();
        int digit = 0;
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                digit = digit * 10 + c - '0';
            }
            else if(c == '['){
                intStack.push(digit);
                strStack.push(decode);
                decode = new StringBuilder();
                digit = 0;
            }
            else if(c == ']'){
                StringBuilder tmp = decode;
                decode = strStack.pop();
                for(digit = intStack.pop(); digit > 0; -- digit){
                    decode.append(tmp);
                }
            }
            else{
                decode.append(c);
            }
        }
        return decode.toString();
    }

    public static void main(String[] args){
        System.out.print(decodeString("3[a]2[bc]"));
    }

}
