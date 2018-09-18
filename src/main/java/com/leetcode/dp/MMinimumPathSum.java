package com.leetcode.dp;

public class MMinimumPathSum {

    private static int min = Integer.MAX_VALUE;

    public static int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0){
            return -1;
        }
        dfs(grid, 0, 0, 0);
        return min;
    }

    private static void dfs(int[][] grid, int i, int j, int sum){
        if(i == grid.length - 1 && j == grid[0].length - 1){
            sum += grid[i][j];
            min = Math.min(min, sum);
            return;
        }
        if(i >= grid.length || j >= grid[0].length){
            return;
        }

        int[][] dirs = {{0, 1}, {1, 0}};

        sum += grid[i][j];

        for(int[] dir: dirs){
            int start = i + dir[0];
            int end = j + dir[1];
            dfs(grid, start, end, sum);
        }

        return;
    }

    public static void main(String[] args){
        int[][] grid = {{1,9,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(grid));
    }

}
