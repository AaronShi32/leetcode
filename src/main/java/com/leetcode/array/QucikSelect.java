package com.leetcode.array;

// Find Kth element Problem
public class QucikSelect {

    public int findKthLargest(int[] a, int k) {
        int n = a.length;
        int p = quickSelect(a, 0, n - 1, n - k + 1);
        return a[p];
    }

    // return the index of the kth smallest number
    private int quickSelect(int[] a, int l, int r, int k) {
        // use quick sort's idea
        // put nums that are <= pivot to the left
        // put nums that are  > pivot to the right
        int i = l, j = r, pivot = a[r];
        while (i < j) {
            if (a[i++] > pivot) swap(a, --i, --j);
        }
        swap(a, i, r);

        // count the nums that are <= pivot from lo
        int m = i - l + 1;

        // pivot is the one!
        if (m == k)
            return i;
            // pivot is too big, so it must be on the left
        else if (m > k)
            return quickSelect(a, l, i - 1, k);
            // pivot is too small, so it must be on the right
        else
            return quickSelect(a, i + 1, r, k - m);
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
