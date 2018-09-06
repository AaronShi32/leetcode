package com.leetcode.search;

import com.util.Idea;

@Idea(use = "dfs[TLE], dp[Accept]")
public class MUniquePaths {

    private static int count = 0;

    public static int uniquePaths(int m, int n) {
        boolean[][] visited = new boolean[m][n];
        dfs(0, 0, m, n, visited);
        return count;
    }

    private static void dfs(int i, int j, int m, int n, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= m || j >= n || visited[i][j]) {
            return;
        }
        if (i == m - 1 && j == n - 1 && !visited[i][j]) {
            count++;
            return;
        }

        visited[i][j] = true;

        dfs(i + 1, j, m, n, visited);
        dfs(i, j + 1, m, n, visited);

        visited[i][j] = false;

        return;

    }


    public static int uniquePaths2(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 1; // for only can move either down or right
                else
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(7, 3));
    }
}
