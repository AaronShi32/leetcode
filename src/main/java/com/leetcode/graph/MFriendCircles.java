package com.leetcode.graph;

public class MFriendCircles {

    /**
     * n * n
     * @param M
     * @return
     */
    public int findCircleNum(int[][] M) {
        if(M == null || M.length == 0)
            return 0;
        int n = M.length, count = 0;
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(M, i, visited);
                count ++;
            }
        }
        return count;
    }

    private void dfs(int[][] M, int i, boolean[] visited){
        visited[i] = true;
        for(int j = 0; j < M.length; j++){
            if(i != j && M[i][j] == 1 && !visited[j]){
                dfs(M, j, visited);
            }
        }
        return;
    }

}
