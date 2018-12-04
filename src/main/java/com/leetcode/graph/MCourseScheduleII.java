package com.leetcode.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 拓扑排序
 */
public class MCourseScheduleII {

    // 拓扑排序 + BFS 记录解
    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        int[][] matrix = new int[numCourses][numCourses];
        int[] indegree = new int[numCourses];

        for(int i = 0; i < prerequisites.length; i++){ //key step: 转化矩阵, 统计各结点入度
            int in = prerequisites[i][0];
            int out = prerequisites[i][1];
            if(matrix[out][in] == 0){
                indegree[in] ++;
            }
            matrix[out][in] = 1;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < numCourses; i++){ // key step: 选择入度为0的节点作为起点
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        int[] r = new int[numCourses];
        int index = 0;

        while(!q.isEmpty()){
            int course = q.poll();
            r[index ++] = course;
            for(int i = 0; i < numCourses; i++){
                if(matrix[course][i] != 0){ // key step: 删除以此节点course为出度的节点的入度值
                    indegree[i]--;
                    if(indegree[i] == 0){
                        q.offer(i);
                    }
                }
            }
        }

        return index == numCourses ? r : new int[]{};
    }

    public static void main(String[] args){
        int numCourses = 2;
        int[][] prerequisites = new int[numCourses][numCourses];
        prerequisites[0] = new int[]{0, 1};
        System.out.println(findOrder(numCourses, prerequisites));
    }

}
