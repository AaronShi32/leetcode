package com.leetcode.prime;

/**
 * 有意思的题目: 找出名人, 他不认识所有人, 但所有人都认识他
 */
public class MFindtheCelebrity {

    /*
     * The knows API is defined in the parent class Relation.
     * boolean knows(int a, int b);
     * a knows b
     */
    private boolean knows(int a, int b){
        return false;
    }

    public int findCelebrity(int n) {
        int candidate = 0;
        //每一次比较只有两种情况，knows(a, b)是true的话，那么a肯定不是candidate; knows(a, b)是false的话，那么b肯定不是candidate. 所以一直比较到最后会留下一个candidate，然后我们再验证这个是不是正解。
        for (int i = 1; i < n; i++) {
            if (knows(candidate, i)) {
                candidate = i;
            }
        }
        for (int i = 0; i < n; i++) {
            if (candidate != i && (knows(candidate, i) || !knows(i, candidate))) {
                return -1;
            }
        }
        return candidate;
    }


}
