package com.leetcode.prime;

/**
 * 糖果消除, 条件: 横纵3个, 消除完自动下落, 直到不可消除的状态
 *
 * 1.每一轮先扫一遍找到所有可以消除的糖果。只向右和向下找，标为负数。
 *
 * 2.实施drop。对每一列把正数挪到最下面，然后上面剩下的set为0.
 *
 * 3.如果这一轮没有发现任何可以消除的糖果就结束循环了。
 *
 * board[i][j] == 0 标识没有糖果
 */
public class MCandyCrush {

    public int[][] candyCrush(int[][] board) {
        int N = board.length, M = board[0].length;
        boolean found = true;
        while (found) {
            found = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int val = Math.abs(board[i][j]);
                    if (val == 0) continue;
                    if (j < M - 2 && Math.abs(board[i][j + 1]) == val && Math.abs(board[i][j + 2]) == val) {
                        found = true;
                        int ind = j;
                        while (ind < M && Math.abs(board[i][ind]) == val) board[i][ind++] = -val; // 负数标识本轮待消除的糖果
                    }
                    if (i < N - 2 && Math.abs(board[i + 1][j]) == val && Math.abs(board[i + 2][j]) == val) {
                        found = true;
                        int ind = i;
                        while (ind < N && Math.abs(board[ind][j]) == val) board[ind++][j] = -val; // 负数标识本轮待消除的糖果
                    }
                }
            }
            if (found) { // move positive values to the bottom, then set the rest to 0
                for (int j = 0; j < M; j++) {
                    int storeInd = N - 1;
                    for (int i = N - 1; i >= 0; i--) {
                        if (board[i][j] > 0) {
                            board[storeInd--][j] = board[i][j];
                        }
                    }
                    for (int k = storeInd; k >= 0; k--) board[k][j] = 0;
                }
            }
        }
        return board;
    }
}
