package com.contest;

import com.util.Contest;

@Contest(id = 65)
public class EProjectionAreaof3DShapes {

    public int projectionArea(int[][] grid) {
        int mX = 0, mY = 0, mZ = 0;

        int m = grid.length;
        int n = grid[0].length;

        // axis-aligned X
        for(int i = 0; i < m; i++){
            int max = 0;
            for(int j = 0; j < n; j++){
                if(grid[i][j] != 0){
                    max = Math.max(max, grid[i][j]);
                }
            }
            mX += max;
        }

        // axis-aligned Y
        for(int j = 0; j < n; j++){
            int max = 0;
            for(int i = 0; i < m; i++){
                if(grid[i][j] != 0){
                    max = Math.max(max, grid[i][j]);
                }
            }
            mY += max;
        }

        // axis-aligned Z
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] != 0){
                    mZ ++;
                }
            }
        }

        return mX + mY + mZ;
    }


    public static void main(String[] args){

        int[][] grid = {{1,1,1},{1,0,1},{1,1,1}};

        EProjectionAreaof3DShapes c = new EProjectionAreaof3DShapes();

        System.out.println(c.projectionArea(grid));
    }

}
