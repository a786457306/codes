package com.zzw.algorithm.linkedlist_stack_queue;

/**
 * FindNumInSortedMatrix
 * 【题目】
 * 给定一个有N*M的整型矩阵matrix和一个整数K，matrix的每一行和每一
 * 列都是排好序的。实现一个函数，判断K是否在matrix中。
 * 例如：
 * 0 1 2 5
 * 2 3 4 7
 * 4 4 4 8
 * 5 7 7 9
 * 如果K为7，返回true；如果K为6，返回false。
 * 【要求】
 * 时间复杂度为O(N+M)，额外空间复杂度为O(1)。
 * 【思路】
 * 从右上角开始找，大于查询元素则左移，小于则下移，找到则true，否则false（左下角也可以）
 *
 * @author Daydreamer
 * @date 2018/4/6 12:18
 */
public class FindNumInSortedMatrix {
    public static boolean isContains(int[][] matrix, int K) {
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col > -1) {
            if (matrix[row][col] == K) {
                return true;
            } else if (matrix[row][col] > K) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}
