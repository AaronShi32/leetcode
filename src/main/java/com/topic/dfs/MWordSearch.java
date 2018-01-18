package com.topic.dfs;

import com.util.Best;
import com.util.Question;
import com.util.Self;

@Question(id = 79, title = "Word Search", hint = "" +
        "1. the same letter cell may not be used more than once")
public class MWordSearch {

    public static boolean[][] visited;

    @Best(thought = "dfs")
    @Self(thought = "miss")
    public static boolean solution(char[][] board, String word){
        int m = board.length, n = board[0].length;
        visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if((word.charAt(0) == board[i][j]) && search(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean search(char[][]board, String word, int i, int j, int index){
        int m = board.length, n = board[0].length;
        if(index == word.length()){
            return true;
        }

        if(i >= m || i < 0 || j >= n || j < 0 || board[i][j] != word.charAt(index) || visited[i][j]){
            return false;
        }

        visited[i][j] = true;

        if(search(board, word, i-1, j, index+1) ||
                search(board, word, i+1, j, index+1) ||
                search(board, word, i, j-1, index+1) ||
                search(board, word, i, j+1, index+1)){
            return true;
        }

        visited[i][j] = false;

        return false;
    }


    public static void main(String[] args){

    }
}
