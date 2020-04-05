package com.zzw.algorithm.linkedlist_stack_queue;

/**
 * CirclePrintArray
 * 转圈打印矩阵
 * 【题目】
 * 给定一个整型矩阵matrix，请按照转圈的方式打印它。
 * 例如：
 * 1 2 3 4
 * 5 6 7 8
 * 9 10 11 12
 * 13 14 15 16
 * 打印结果为：1，2，3，4，8，12，16，15，14，13，9，5，6，7，11，
 * 10
 * 【要求】
 * 额外空间复杂度为O(1)。
 *
 * @author Daydreamer
 * @date 2018/3/30 16:24
 */
public class CirclePrintArray {
    public static void spiralOrderPrint(int[][] matrix) {
        int row1 = 0;
        int col1 = 0;
        int row2 = matrix.length - 1;
        int col2 = matrix[0].length - 1;
        while (row1 <= row2 && col1 <= col2) {
            circlePrint(matrix, row1++, row2--, col1++, col2--);
        }
    }

    public static void circlePrint(int[][] arr, int row1, int row2, int col1, int col2) {
        if (row1 == row2) {
            for (int i = col1; i <= col2; i++) {
                System.out.print(arr[row1][i] + " ");
            }
        } else if (col1 == col2) {
            for (int i = row1; i <= row2; i++) {
                System.out.print(arr[i][col1] + " ");
            }
        } else {
            while (col1 < col2) {
                System.out.print(arr[row1][col1++] + " ");
            }
            while (row1 < row2) {
                System.out.print(arr[row1++][col2] + " ");
            }
            while (col2 > col1) {
                System.out.print(arr[row2][col2--] + " ");
            }
            while (row2 > row1) {
                System.out.print(arr[row2--][col1] + " ");
            }
        }
    }
}
