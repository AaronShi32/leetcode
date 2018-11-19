package com.leetcode.prime;

import java.util.TreeSet;

/**
 * 解法一：最优解法，时间复杂度为O(n)，空间复杂度为O(n)，思路是用额外空间记录一下1 ~ n个花槽，是第几天开花。再从头遍历，看看每隔K天两个花槽之间有没有更早的天数，没有则更新result，有则从天数最早的index向后走直到right走到最后。
 */
public class HKEmptySlots {

    public int kEmptySlots(int[] flowers, int k) {
        int n = flowers.length;
        if (n == 1 && k == 0) return 1;
        TreeSet<Integer> sort = new TreeSet<>();
        for (int i = 0; i < n; ++i) {
            sort.add(flowers[i]);
            Integer min = sort.lower(flowers[i]);
            Integer max = sort.higher(flowers[i]);
            if (min != null && flowers[i] - min == k + 1) return i + 1;
            if (max != null && max - flowers[i] == k + 1) return i + 1;
        }
        return -1;
    }
}
