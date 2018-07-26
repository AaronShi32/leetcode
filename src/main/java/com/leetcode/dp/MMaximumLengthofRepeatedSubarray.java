package com.topic.dp;

import com.util.Best;
import com.util.Question;
import com.util.Self;

@Question(id = 718, title = "Maximum Length of Repeated Subarray", hint = "" +
        "1. Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays" +
        "2. 1 <= len(A), len(B) <= 1000, 0 <= A[i], B[i] < 100")
public class MMaximumLengthofRepeatedSubarray {

    @Best(thought = "dp martix")
    @Self(thought = "miss")
    public static int solution(int[] A, int[] B){
        /*
         * dp[i][j] = a[i] == b[j] ? dp[i + 1][j + 1] : 0;
         * dp[i][j] : max lenth of common subarray start at a[i] & b[j];
         */
        int m = A.length, n = B.length;
        if (m == 0 || n == 0) return 0;
        int[][] dp = new int[m + 1][n + 1];
        int max = 0;
        for (int i = m - 1; i >= 0; i--)
            for (int j = n - 1; j >= 0; j--)
                max = Math.max(max, dp[i][j] = A[i] == B[j] ? 1 + dp[i + 1][j + 1] : 0);
        return max;
    }

}
