package com.leetcode.prime;

public class MNextClosestTime {

    /**
     * 最优解法，时间复杂度为O(4*10)，空间复杂度为O(10)
     * @param time
     * @return
     */
    public static String nextClosestTime(String time) {
        char[] t = time.toCharArray(), result = new char[4];
        // min
        int[] list = new int[10];
        char min = '9';
        for (char c : t) { // key step: get min digit
            if (c == ':') continue;
            list[c - '0']++;
            if (c < min) {
                min = c;
            }
        }
        //
        for (int i = t[4] - '0' + 1; i <= 9; i++) { // 如果二分针在9以内可以走到, 直接返回
            if (list[i] != 0) {
                t[4] = (char)(i + '0');
                return new String(t);
            }
        }
        t[4] = min; // key step: t[3,4] = min
        for (int i = t[3] - '0' + 1; i <= 5; i++) { // 如果一分针在5以内可以走到, 直接返回
            if (list[i] != 0) {
                t[3] = (char)(i + '0');
                return new String(t);
            }
        }
        t[3] = min;
        int stop = t[0] < '2' ? 9 : 3; // key step: // 根据一时针判断二时针的范围是9还是3
        for (int i = t[1] - '0' + 1; i <= stop; i++) {
            if (list[i] != 0) {
                t[1] = (char)(i + '0');
                return new String(t);
            }
        }
        t[1] = min;
        for (int i = t[0] - '0' + 1; i <= 2; i++) {
            if (list[i] != 0) {
                t[0] = (char)(i + '0');
                return new String(t);
            }
        }
        t[0] = min;
        return new String(t);
    }

    public static String interview(String time){
        char[] t = time.toCharArray(), ans = new char[4];
        int[] list = new int[10];
        char min = '9';
        for(char c : t){
            if(c == ':') continue;
            list[c - '0'] ++;
            if(c < min){
                min = c;
            }
        }

        for(int i = t[4] - '0' + 1; i <= 9; i++){
            if(list[i] != 0){
                t[4] = (char)(i + '0');
                return new String(t);
            }
        }
        t[4] = min;

        for(int i = t[3] - '0' + 1; i <= 5; i++){
            if(list[i] != 0){
                t[3] = (char)(i + '0');
                return new String(t);
            }
        }
        t[3] = min;

        int limit = t[0] < '2' ? 9 : 3;
        for(int i = t[1] - '0' + 1; i <= limit; i++){
            if(list[i] != 0){
                t[1] = (char)(i + '0');
                return new String(t);
            }
        }

        t[1] = min;

        for(int i = t[0] - '0' + 1; i <= 2; i++){
            if(list[i] != 0){
                t[0] = (char)(i + '0');
                return new String(t);
            }
        }
        t[0] = min;

        return new String(t);

    }


    public static void main(String[] args){
        // 一定是 next time
        System.out.println(nextClosestTime("23:59"));
    }
}
