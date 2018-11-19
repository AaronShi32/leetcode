package com.leetcode.dfs;

public class MMaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j, 0);
                    max = Math.max(area, max);
                }
            }
        }
        return max;
    }

    private int dfs(int[][] grid, int i, int j, int area) {

        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1){
            return area; // key step
        }

        grid[i][j] = 0;
        area ++;

        area = dfs(grid, i, j + 1, area); // key step 向右扩展
        area = dfs(grid, i, j - 1, area);
        area = dfs(grid, i + 1, j, area);
        area = dfs(grid, i - 1, j, area);

        return area;

    }
}
