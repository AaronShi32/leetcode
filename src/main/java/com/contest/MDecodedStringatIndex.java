package com.contest;

public class MDecodedStringatIndex {

    public String decodeAtIndex(String S, int K) {
        StringBuilder storage = new StringBuilder("");
        int len = 0;
        for(char c: S.toCharArray()){
            if(Character.isDigit(c)){
                int count = c - '0';
                len = len * count;
                String copy = storage.toString();
                if(len >= K){
                    int mod = (K-1) % copy.length();
                    return copy.charAt(mod) + "";
                }
                for(int i = 0; i < count - 1; i++){
                    storage.append(copy);
                }
            }else{
                storage.append(c);
                len++;
            }
            if(len >= K){
                break;
            }
        }

        return storage.charAt(K - 1) + "";
    }

    public static void main(String[] args){
        String S = "ixm5xmgo78";
        int K = 711;
        MDecodedStringatIndex c = new MDecodedStringatIndex();
        System.out.println(c.decodeAtIndex(S, K));
    }

}
